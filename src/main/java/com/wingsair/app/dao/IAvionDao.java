package com.wingsair.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wingsair.app.models.Avion;

public interface IAvionDao extends JpaRepository<Avion, Long>{

}
