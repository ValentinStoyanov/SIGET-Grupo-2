package com.example.demo;


import static org.junit.Assert.fail;

import java.io.IOException;

import org.json.JSONException;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PasosConvocar extends SigetGrupo2ApplicationTest{
	
	private OkHttpClient client;
	private Request request;
	
	@Given("el usuario intenta crear una reunion")
	public void el_usuario_intenta_crear_una_reunion() {
		System.out.println("El usuario esta intentando crear una reunion");
	}
	
	@When("el cliente hace la llamada POST/llena el formulario con los parametros de una reunion: temas {temas} descripcion {descripcion>} hora_inicio {hora_inicio>} hora_fin {hora_fin>} asistentes {asistentes} convocante {convocante>}")
	public void el_cliente_rellena_el_formulario(String tema, String descripcion, String hora_inicio, String hora_fin,String [] asistentes, String convocante ) {
				client = new OkHttpClient();
				MediaType mediaType = MediaType.parse("text/plain");
				MediaType JSON = MediaType.parse("application/json; charset=utf-8");
				RequestBody body = RequestBody.create(JSON, "{}");
				Request request = new Request.Builder()
				  .url("http://localhost:8080/reuniones/getAll?tema="+ tema +"&descripcion="+ descripcion +"&hora_inicio="+ hora_inicio +"&hora_fin="+ hora_fin +"&asistentes="+ asistentes +"&convocantes="+ convocante )
				  .post(body)
				  .build();

		
	}
	
	@Then("el cliente recibe respuesta de que la reunion es guardada en la base de datos, todo queda guardado {guardado}")
	public void el_cliente_recibe_respuesta_de_que_la_reunion_es_guardada_en_la_base_de_datos (String guardado)throws IOException, JSONException {
		try {
			Response response = client.newCall(request).execute();
		    String body= response.body().string();
			if(guardado.equals("true")) {
				if(body.equals("false")) {
			        fail("La respuesta da error pero debería ser afirmativa");
			      }
			    }else{
			      if(body.equals("true")) {
			        fail("La respuesta es afirmativa pero debería dar error");
			      }
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			fail("Error en la llamada http");
			
		}
		
	}




}