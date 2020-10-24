@tag
Feature: Login can be performed
	@tag1
	Scenario: El cliente hace la llamada POST /login a la API
		When el servidor recibe la llamada POST /login
		Then el cliente recibe la respuesta de que el login es correcto