package com.model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Reuniones")
public class Reunion {
	
	private String temas;
	private String descripcion;
	private String fecha;
	private String hora_inicio;
	private String hora_fin;
	private String[] asistentes;
	private String convocante;
	

	public Reunion(String temas, String descripcion,String fecha, String hora_inicio, String hora_fin, String[] asistentes,
			String convocante) {
		super();
		this.temas = temas;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
		this.asistentes = asistentes;
		this.convocante = convocante;
	}


	public String getTemas() {
		return temas;
	}


	public void setTemas(String temas) {
		this.temas = temas;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
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


	public String[] getAsistentes() {
		return asistentes;
	}


	public void setAsistentes(String[] asistentes) {
		this.asistentes = asistentes;
	}


	public String getConvocante() {
		return convocante;
	}


	public void setConvocante(String convocante) {
		this.convocante = convocante;
	}
	
}