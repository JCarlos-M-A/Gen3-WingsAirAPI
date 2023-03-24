package com.wingsair.app.dtos;

public class PilotoListDTO {
	
	private Long id;
	private String codigo;
	private String nombre;
	private String sexo;
	private Integer horas;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Integer getHoras() {
		return horas;
	}
	public void setHoras(Integer horas) {
		this.horas = horas;
	}

}
