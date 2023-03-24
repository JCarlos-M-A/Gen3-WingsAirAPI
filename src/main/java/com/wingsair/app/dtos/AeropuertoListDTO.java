package com.wingsair.app.dtos;

import java.util.Set;

import com.wingsair.app.models.Tiempos;

public class AeropuertoListDTO {
	
	private Long id;
	private String nombre;
	private String municipio;
	private String estado;
	private String pais;
	private Set<TiempoListDTO> tiempo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public Set<TiempoListDTO> getTiempo() {
		return tiempo;
	}
	public void setTiempo(Set<TiempoListDTO> tiempo) {
		this.tiempo = tiempo;
	}
	
}
