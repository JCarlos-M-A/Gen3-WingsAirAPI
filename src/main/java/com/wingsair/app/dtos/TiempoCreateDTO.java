package com.wingsair.app.dtos;

public class TiempoCreateDTO {

	private Long id;
	private Long origen;
	private Long destino;
	private Integer horas;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrigen() {
		return origen;
	}
	public void setOrigen(Long origen) {
		this.origen = origen;
	}
	public Long getDestino() {
		return destino;
	}
	public void setDestino(Long destino) {
		this.destino = destino;
	}
	public Integer getHoras() {
		return horas;
	}
	public void setHoras(Integer horas) {
		this.horas = horas;
	}

}
