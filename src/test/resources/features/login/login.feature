Feature: Login
@smoke
Scenario: Login correcto

Given estoy en la pagina de login
When ingreso al usuario "admin" contraseña "1234"
Then deberia redirigir a "/users"