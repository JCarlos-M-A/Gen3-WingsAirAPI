package com.wingsair.app.dtos;

public class TiempoListDTO {

	private Long id;
	private AeropuertoNombres origen;
	private AeropuertoNombres destino;
	private Integer horas;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public AeropuertoNombres getOrigen() {
		return origen;
	}
	public void setOrigen(AeropuertoNombres origen) {
		this.origen = origen;
	}
	public AeropuertoNombres getDestino() {
		return destino;
	}
	public void setDestino(AeropuertoNombres destino) {
		this.destino = destino;
	}
	public Integer getHoras() {
		return horas;
	}
	public void setHoras(Integer horas) {
		this.horas = horas;
	}

}
