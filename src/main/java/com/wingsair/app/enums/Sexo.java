package com.wingsair.app.enums;

public enum Sexo {
	MASCULINO("Masculino"),
	FEMENINO("Femenino");
	
private String descripcion;
	
	private Sexo (String descripcion){
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public static Sexo getFromString(String descripcion) {
		switch (descripcion) {
		case "Masculino": {
			return MASCULINO;
		}
		case "Femenino": {
			return FEMENINO;
		}
		default:
			return null;
		}
	} 
}
