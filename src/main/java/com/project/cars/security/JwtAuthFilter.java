package com.project.cars.security;

import com.project.cars.exception.UnauthorizedException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtAuthenticationProvider authProvider;
    private final List<String> urlsToSkip = List.of("/auth", "/swagger-ui.html", "/swagger-ui", "/api-docs");

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return urlsToSkip.stream().anyMatch(url -> request.getRequestURI().contains(url));
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (header == null) {
            throw new UnauthorizedException();
        }

        String[] authElements = header.split(" ");

        if (authElements.length != 2 || !"Bearer".equals(authElements[0])) {
            throw new UnauthorizedException();
        }

        try {
            Authentication authentication = authProvider.validateToken(authElements[1]);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (RuntimeException ex) {
            SecurityContextHolder.clearContext();
            throw new RuntimeException( ex );
        }

        filterChain.doFilter(request, response);
    }
}
