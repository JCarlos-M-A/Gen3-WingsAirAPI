package com.wingsair.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wingsair.app.models.Tiempos;

public interface ITiempoDao extends JpaRepository<Tiempos, Long>{

}
