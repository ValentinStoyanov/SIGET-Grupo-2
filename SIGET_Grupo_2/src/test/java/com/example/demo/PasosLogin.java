package com.example.demo;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PasosLogin extends SigetGrupo2ApplicationTest{
	private OkHttpClient client;
	private Request request;
	
	@Given("el usuario intenta logearse")
	public void el_usuario_intenta_logearse() {
	    System.out.println("Usuario intentado logearse...");
	}
	@When("el cliente hace la llamada POST \\/login con los parámetros username {string} y password {string}")
	public void el_cliente_hace_la_llamada_post_login_con_los_parámetros_username_y_password(String username, String password) throws IOException {
		client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("text/plain");
		RequestBody body = RequestBody.create(mediaType, "");
		request = new Request.Builder()
				.url("http://localhost:8080/usuarios/login?username="+ username + "&password=" + password)
				.method("POST", body)
				.build();
	}
	@Then("el cliente recibe la respuesta de que el login es {string}")
	public void el_cliente_recibe_la_respuesta_de_que_el_login_es_correcto(String correcto) throws IOException, JSONException {
		try {
			Response response = client.newCall(request).execute();
		    String body= response.body().string();
		    System.out.println(response.toString());
		    JSONObject jsonObject = new JSONObject(body);
			if(correcto.equals("True")) {
		      if(jsonObject.get("type").equals("error")) {
		        fail("La respuesta da error pero debería ser afirmativa");
		      }
		    }else{
		      if(!jsonObject.get("type").equals("error")) {
		        fail("La respuesta es afirmativa pero debería dar error");
		      }
		    }
		}catch(Exception e){
			//e.printStackTrace();
		    fail("Error en la llamada http");
		}
	}
}
