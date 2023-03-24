package com.wingsair.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wingsair.app.models.Piloto;

public interface IPilotosDao extends JpaRepository<Piloto, Long>{

}
