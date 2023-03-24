package com.wingsair.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wingsair.app.models.Aeropuerto;

public interface IAeropuertoDao extends JpaRepository<Aeropuerto, Long>{

}
