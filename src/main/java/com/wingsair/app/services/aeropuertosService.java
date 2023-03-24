package com.wingsair.app.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wingsair.app.dao.IAeropuertoDao;
import com.wingsair.app.dao.ITiempoDao;
import com.wingsair.app.dtos.AeropuertoCreateDTO;
import com.wingsair.app.dtos.AeropuertoListDTO;
import com.wingsair.app.dtos.AvionListDTO;
import com.wingsair.app.dtos.TiempoListDTO;
import com.wingsair.app.enums.Tipos;
import com.wingsair.app.models.Aeropuerto;
import com.wingsair.app.models.Avion;
import com.wingsair.app.models.Tiempos;

@Component
public class aeropuertosService implements IService<AeropuertoListDTO, AeropuertoCreateDTO>{

	@Autowired
	private IAeropuertoDao aeropuertosDao;
	
	@Autowired
	private ITiempoDao tiemposDao;
	
	@Override
	public AeropuertoListDTO create(AeropuertoCreateDTO obj) {
		Aeropuerto aero = this.dtoToEntity(obj);
		Aeropuerto aeroNueva = aeropuertosDao.save(aero);
		return this.entityToDto(aeroNueva);
	}

	@Override
	public List<AeropuertoListDTO> getAll() {
		List<AeropuertoListDTO> listaDTO = new ArrayList<>();
		List<Aeropuerto> lista = aeropuertosDao.findAll();
		for (Aeropuerto aero : lista) {
			listaDTO.add(this.entityToDto(aero));
		}
		return listaDTO;
	}

	@Override
	public AeropuertoListDTO getById(long id) {
		Aeropuerto aero = aeropuertosDao.findById(id).orElseThrow(() -> new RuntimeException());
		return this.entityToDto(aero);
	}

	@Override
	public AeropuertoListDTO update(AeropuertoCreateDTO obj, long id) {
		Aeropuerto aero = aeropuertosDao.findById(id).orElseThrow(() -> new RuntimeException());
		aero.setId(obj.getId());
		
		Aeropuerto aeroActual = aeropuertosDao.save(aero);
		return this.entityToDto(aeroActual);
	}

	@Override
	public void delete(long id) {
		Optional<Aeropuerto> aero = aeropuertosDao.findById(id);
		if(aero.isPresent()) {
			aeropuertosDao.delete(aero.get());
		}else {
			
		}
	}
	
	public Aeropuerto dtoToEntity(AeropuertoCreateDTO aeroDTO) {
		Aeropuerto aeropuerto = new Aeropuerto();
		aeropuerto.setId(aeroDTO.getId());
		aeropuerto.setEstado(aeroDTO.getEstado());
		aeropuerto.setMunicipio(aeroDTO.getMunicipio());
		aeropuerto.setNombre(aeroDTO.getNombre());
		aeropuerto.setPais(aeroDTO.getPais());
		
		Set<Tiempos> tiempos = new HashSet();
		if(aeroDTO.getTiempo()!=null) {
			Optional<Tiempos> tiempo = tiemposDao.findById(aeroDTO.getTiempo());
			if(tiempo.isPresent()) {
				tiempos.add(tiempo.get());
			}else {
				
			}
		}
		aeropuerto.setTiempos(tiempos);
		
		return aeropuerto;
	}
	
	public AeropuertoListDTO entityToDto(Aeropuerto aero) {
		AeropuertoListDTO aeroDto = new AeropuertoListDTO();
		aeroDto.setId(aero.getId());
		aeroDto.setEstado(aero.getEstado());
		aeroDto.setMunicipio(aero.getMunicipio());
		aeroDto.setNombre(aero.getNombre());
		aeroDto.setPais(aero.getPais());
		if(aero.getTiempos()!=null) {
			for (int i = 0; i < aero.getTiempos().size(); i++) {
				TiempoListDTO tiempo = new TiempoListDTO();
			}
			
			//aeroDto.setTiempo();	
		}
		
		
		return aeroDto;
	}
}