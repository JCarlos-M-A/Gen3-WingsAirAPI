package com.wingsair.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tiempos")
public class Tiempos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIEMPO_SEQTIME")
	@SequenceGenerator(sequenceName = "tiempo_seqtime", allocationSize = 1, name = "TIEMPO_SEQTIME")
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "origen")
	private Aeropuerto origen;
	
	@ManyToOne
	@JoinColumn(name = "destino")
	private Aeropuerto destino;
	
	@Column(name = "horas")
	private Integer horas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aeropuerto getOrigen() {
		return origen;
	}

	public void setOrigen(Aeropuerto origen) {
		this.origen = origen;
	}

	public Aeropuerto getDestino() {
		return destino;
	}

	public void setDestino(Aeropuerto destino) {
		this.destino = destino;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

}
