# Project Cars

Esta aplicación está desarrollada en Spring Boot y consta de un CRUD que opera en varias tablas de la base de datos. Se han implementado relaciones con `JPA` para gestionar la persistencia de datos. Además, se ha integrado seguridad mediante JWT (`JSON Web Tokens`), y la aplicación sigue una arquitectura hexagonal para una organización eficiente y modular del código.

## Requisitos

Asegúrate de tener instalados los siguientes requisitos en tu sistema:

- Java JDK >= 17
- Gradle
- PostgreSQL

## Configuración

1. Clona este repositorio: 
```bash
git clone https://github.com/tu-usuario/tu-proyecto.git`
```
2. Entra al directorio del proyecto: `cd tu-proyecto

## Construcción y Ejecución

Para construir y ejecutar el proyecto, utiliza Gradle:

```bash
./gradlew build
./gradlew bootRun
```