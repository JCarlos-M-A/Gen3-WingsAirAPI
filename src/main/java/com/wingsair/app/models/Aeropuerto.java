package com.wingsair.app.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "aeropuertos")
public class Aeropuerto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AEROPUERTO_SEQAERO")
	@SequenceGenerator(sequenceName = "aeropuerto_seqaero", allocationSize = 1, name = "AEROPUERTO_SEQAERO")
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "municipio")
	private String municipio;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "pais")
	private String pais;
	
	@OneToMany(mappedBy="destino")
	private Set<Tiempos> tiempos;

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

	public Set<Tiempos> getTiempos() {
		return tiempos;
	}

	public void setTiempos(Set<Tiempos> tiempos) {
		this.tiempos = tiempos;
	}
	
}
