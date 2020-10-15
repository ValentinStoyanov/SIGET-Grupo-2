package com.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Tarea")
public class Reunion implements Serializable{
	private String _id;
	private String contenido;
	private boolean completada;
	
	public Reunion(String _id, String contenido, boolean completada) {
		super();
		this._id = _id;
		this.contenido = contenido;
		this.completada = completada;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public boolean isCompletada() {
		return completada;
	}

	public void setCompletada(boolean completada) {
		this.completada = completada;
	}
	
}
