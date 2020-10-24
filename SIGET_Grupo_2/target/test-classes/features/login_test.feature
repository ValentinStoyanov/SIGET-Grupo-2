@tag
Feature: Login funciona correctamente
	@tag1
	Scenario Outline: El cliente hace la llamada POST /login a la API
		Given el usuario está registrado en la base de datos
		When el servidor recibe la llamada POST /login
		Then el cliente recibe la respuesta de que el login es correcto
	
	Examples: 
      | username  | password  | status  |
      | name1     | pass1     | success |
      | name2     | pass2     | Fail    |