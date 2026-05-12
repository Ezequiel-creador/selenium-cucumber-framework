Feature: Usuarios
@regression

Scenario: Ver la lista de usuarios

Given estoy logueado
When ingreso a la página de usuarios
Then deberia ver la lista de usuarios
And hay al menos 1 usuarios

Scenario: Crear usuarios

Given estoy en la página de usuarios
When creo un nuevo usuario
Then deberia ver el nuevo usuario en la lista

Scenario: Eliminar usuario

Given estoy en la página de usuarios
And creo un nuevo usuario
When elimino el usuario creado
Then el usuario deberia haber sido eliminado

Scenario: Edito Usuarios

Given estoy en la página de usuarios
And creo un nuevo usuario
When edito el nuevo usuario creado
Then el usuario deberia haber sido editado