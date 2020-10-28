package com.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Calendario")
public class Calendario {
	

	private String horainicio;
	private String horafin;
	private String enlace;
	
	
	public Calendario(String horainicio, String horafin, String enlace) {
		super();
		this.horainicio = horainicio;
		this.horafin = horafin;
		this.enlace = enlace;
	}


	public String getHorainicio() {
		return horainicio;
	}


	public void setHorainicio(String horainicio) {
		this.horainicio = horainicio;
	}


	public String getHorafin() {
		return horafin;
	}


	public void setHorafin(String horafin) {
		this.horafin = horafin;
	}


	public String getEnlace() {
		return enlace;
	}


	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}


	

}
