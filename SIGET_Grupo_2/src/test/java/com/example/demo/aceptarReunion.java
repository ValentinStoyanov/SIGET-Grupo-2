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

public class aceptarReunion extends SigetGrupo2ApplicationTest{
	private OkHttpClient client;
	private Request request;
	
	@Given("El usuario intenta aceptar la reunion")
	public void el_usuario_intenta_aceptar_reunion() {
	    System.out.println("El usuairo no ha aceptardo la reunion...");
	}
	
	@When("El usuario acepta la llamada al post para aceptar la reunion {string}, {string}, {string}, {string}, {string}, {string}")
	public void el_usuario_acepta_la_llamada_al_post_para_aceptar_la_reunion(String temas, String descripcion, String hora_inicio, String hora_fin, String asistentes, String convocantes) throws IOException {
		client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("text/plain");
		RequestBody body = RequestBody.create(mediaType, "");
		request = new Request.Builder()
		          .url("http://localhost:8080/reuniones/aceptarReunion?temas="+ temas + "&descripcion=" + descripcion + "&hora_inicio=" + hora_inicio + "&hora_fin=" + hora_fin + "&asistentes=" + asistentes + "&convocantes=" + convocantes)
		          .post(body)
		          .addHeader("Content-Type", "application/json")
		          .addHeader("User-Agent", "PostmanRuntime/7.19.0")
		          .addHeader("Accept", "/")
		          .addHeader("Cache-Control", "no-cache")
		          .addHeader("Postman-Token", "026c8d66-5ccb-453f-b1b4-c6f351f126ee,ca3db196-6148-4d81-a889-94d79002afe4")
		          .addHeader("Accept-Encoding", "gzip, deflate")
		          .addHeader("Content-Length", "84")
		          .addHeader("Connection", "keep-alive")
		          .addHeader("cache-control", "no-cache")
		          .build();
	}
	
	@Then("El usuario recibe que la reunion ha sido aceptada {string}")
	public void el_usuario_recibe_que_la_reunion_ha_sido_aceptada(String correcto) throws IOException, JSONException {
		try {
			Response response = client.newCall(request).execute();
		    String body= response.body().string();
			if(correcto.equals("True")) {
		      if(body.equals("false")) {
		        fail("La respuesta da error pero debería ser afirmativa");
		      }
		    }else{
		      if(body.equals("true")) {
		        fail("La respuesta es afirmativa pero debería dar error");
		      }
		    }
		}catch(Exception e){
			e.printStackTrace();
		    fail("Error en la llamada http");
		}
	}
}

