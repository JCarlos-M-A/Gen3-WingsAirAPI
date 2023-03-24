package com.wingsair.app.enums;

public enum Tipos {
	AIRBUS_319("AIRBUS 319"),
	AIRBUS_320("AIRBUS 320"),
	AIRBUS_321("AIRBUS 321"),
	AIRBUS_330("AIRBUS 330"),
	AIRBUS_340("AIRBUS 340"),
	AIRBUS_300600("AIRBUS 300-600"),
	BOEING_737("BOEING 737"),
	BOEING_777("BOEING 777"),
	ANTONOV("ANTONOV");
	
	private String descripcion;
	
	private Tipos (String descripcion){
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public static Tipos getFromString(String descripcion) {
		switch (descripcion) {
		case "AIRBUS 319": {
			return AIRBUS_319;
		}
		case "AIRBUS 320": {
			return AIRBUS_320;
		}
		case "AIRBUS 321": {
			return AIRBUS_321;
		}
		case "AIRBUS 330": {
			return AIRBUS_330;
		}
		case "AIRBUS 340": {
			return AIRBUS_340;
		}
		case "AIRBUS 300-600": {
			return AIRBUS_300600;
		}
		case "BOEING 737": {
			return BOEING_737;
		}
		case "BOEING 777": {
			return BOEING_777;
		}
		case "ANTONOV": {
			return ANTONOV;
		}
		default:
			return null;
		}
	} 
}
