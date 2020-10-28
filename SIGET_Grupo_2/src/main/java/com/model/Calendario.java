package com.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Calendario")
public class Calendario {
	

	private String hora_inicio;
	private String hora_fin;
	private String enlace_reunion;
	
	
	public Calendario(String hora_inicio, String hora_fin, String enlace_reunion) {
		super();
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
		this.enlace_reunion = enlace_reunion;
	}


	public String getHora_inicio() {
		return hora_inicio;
	}


	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}


	public String getHora_fin() {
		return hora_fin;
	}


	public void setHora_fin(String hora_fin) {
		this.hora_fin = hora_fin;
	}


	public String getEnlace_reunion() {
		return enlace_reunion;
	}


	public void setEnlace_reunion(String enlace_reunion) {
		this.enlace_reunion = enlace_reunion;
	}

}
