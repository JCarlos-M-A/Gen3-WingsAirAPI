package com.wingsair.app.models;

import com.wingsair.app.enums.Sexo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "pilotos")
public class Piloto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PILOTO_SEQPIL")
	@SequenceGenerator(sequenceName = "piloto_seqpilo", allocationSize = 1, name = "PILOTO_SEQPIL")
	@Column(name = "id")
	private Long id;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "sexo")
	private Sexo sexo;
	
	@Column(name = "horas")
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

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

}
