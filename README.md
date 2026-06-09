# Selenium Cucumber Automation Framework

Proyecto de automatización de pruebas UI desarrollado con Java, Selenium WebDriver y Cucumber siguiendo el patrón Page Object Model (POM).

El framework fue diseñado para automatizar flujos funcionales de una aplicación web desarrollada con Spring Boot, Thymeleaf y Spring Security.

## Technologies

* Java
* Selenium WebDriver
* Cucumber
* JUnit 5
* Maven
* Page Object Model (POM)
* Spring Boot
* Thymeleaf
* Spring Security
* Extent Reports
* Jenkins
* Git & GitHub

## Test Types

* Smoke Testing
* Regression Testing
* Functional Testing
* Authentication Testing
* User Management Testing

## Features

### Authentication Testing

* Login con credenciales válidas
* Login con credenciales inválidas
* Verificación de redirección a página de usuarios
* Validación de mensajes de error

### User Management Testing

* Consulta de usuarios
* Navegación entre pantallas
* Validación de funcionalidades CRUD
* Verificación de comportamiento esperado de la interfaz

### Framework Design

* Implementación de Page Object Model (POM)
* Escenarios BDD utilizando Cucumber y Gherkin
* Reutilización de componentes mediante Page Objects
* Gestión centralizada del WebDriver mediante DriverFactory
* Hooks para configuración y cierre de escenarios
* Generación de reportes HTML con Extent Reports
* Ejecución automatizada mediante Jenkins

## Project Structure

```text
src/test/java/com/proyect
├── DriverFactory.java
├── Hooks.java
├── LoginPage.java
├── UsersPage.java
├── LoginSteps.java
├── UsersSteps.java
└── TestRunnerTest.java

src/test/resources/features
├── login
│   └── login.feature
└── users
    └── users.feature
```

## Running Tests

```bash
mvn test
```

## Reports

El proyecto genera reportes HTML mediante Extent Reports para visualizar los resultados de ejecución de forma detallada.

## Continuous Integration

El proyecto incorpora integración con Jenkins para la ejecución automatizada de pruebas UI.

## Author

Ezequiel Figueroa

QA Automation Engineer (Junior)

Java | Selenium | Cucumber | Rest Assured | Spring Boot | Jenkins | Azure DevOps
