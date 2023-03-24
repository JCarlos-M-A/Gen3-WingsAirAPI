package com.wingsair.app.models;

import com.wingsair.app.enums.Tipos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "aviones")
public class Avion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AVO_SEQAVO")
	@SequenceGenerator(sequenceName = "avion_seqavo", allocationSize = 1, name = "AVO_SEQAVO")
	@Column(name = "id")
	private Long id;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "tipoAvion")
	private Tipos tipoAvion;
	
	@Column(name = "horas")
	private Integer horas;
	
	@Column(name = "capacidad")
	private Integer capacidad;

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

	public Tipos getTipoAvion() {
		return tipoAvion;
	}

	public void setTipoAvion(Tipos tipoAvion) {
		this.tipoAvion = tipoAvion;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
}
