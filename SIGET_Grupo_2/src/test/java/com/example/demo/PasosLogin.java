package com.example.demo;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PasosLogin extends SigetGrupo2ApplicationTest{
	
	@Given("el usuario está registrado en la base de datos")
	public void usuarioRegistrado() throws Throwable{
	    /*Comprobar que el usuario con nombre name1 y contraseña pass1 está en la base de datos*/
		System.out.println("Entra al Given");
	}
	
	@When("el servidor recibe la llamada POST \\/login")
	public void llamadaLogin() throws Throwable{
		OkHttpClient client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("text/plain");
		MediaType JSON = MediaType.parse("application/json; charset=utf-8");
		RequestBody body = RequestBody.create(JSON, "{}");
		Request request = new Request.Builder()
				.url("http://localhost:8080/login?username=name&password=pass1 ")
				.method("POST", body)
				.build();
		Response response = client.newCall(request).execute();
		System.out.println(response);
	}
	 
	@Then("el cliente recibe la respuesta de que el login es correcto")
	public void respuestaLogin() throws Throwable {
		System.out.println("Entra al Then");
	}
}
