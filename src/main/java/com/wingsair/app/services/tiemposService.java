package com.wingsair.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wingsair.app.dao.IAeropuertoDao;
import com.wingsair.app.dao.ITiempoDao;
import com.wingsair.app.dtos.AeropuertoNombres;
import com.wingsair.app.dtos.TiempoCreateDTO;
import com.wingsair.app.dtos.TiempoListDTO;
import com.wingsair.app.models.Aeropuerto;
import com.wingsair.app.models.Tiempos;
@Component
public class tiemposService implements IService<TiempoListDTO, TiempoCreateDTO>{
	
	@Autowired
	private ITiempoDao tiemposDao;
	
	@Autowired
	private IAeropuertoDao aeropuertosDao;

	@Override
	public TiempoListDTO create(TiempoCreateDTO obj) {
		Tiempos tiempos = this.dtoToEntity(obj);
		Tiempos tiempoNuevo = tiemposDao.save(tiempos);
		return this.entityToDto(tiempoNuevo);
	}

	@Override
	public List<TiempoListDTO> getAll() {
		List<TiempoListDTO> listaDTO = new ArrayList<>();
		List<Tiempos> lista = tiemposDao.findAll();
		for (Tiempos tiempo : lista) {
			listaDTO.add(this.entityToDto(tiempo));
		}
		return listaDTO;
	}

	@Override
	public TiempoListDTO getById(long id) {
		Tiempos tiempo = tiemposDao.findById(id).orElseThrow(() -> new RuntimeException());
		return this.entityToDto(tiempo);
	}

	@Override
	public TiempoListDTO update(TiempoCreateDTO obj, long id) {
		Tiempos tiempos = tiemposDao.findById(id).orElseThrow(() -> new RuntimeException());
		tiempos.setId(obj.getId());
		if(obj.getDestino()!=null) {
		Optional<Aeropuerto> aero = aeropuertosDao.findById(obj.getDestino());
		if(aero.isPresent()) {
			tiempos.setDestino(aero.get());
		}
		}
		if(obj.getOrigen()!=null) {
			Optional<Aeropuerto> aero = aeropuertosDao.findById(obj.getOrigen());
			if(aero.isPresent()) {
				tiempos.setOrigen(aero.get());
			}
			}
		tiempos.setHoras(obj.getHoras());
		
		Tiempos tiempoActual = tiemposDao.save(tiempos);
		return this.entityToDto(tiempoActual);
	}

	@Override
	public void delete(long id) {
		Optional<Tiempos> tiempos = tiemposDao.findById(id);
		if(tiempos.isPresent()) {
			tiemposDao.delete(tiempos.get());
		}else {
			
		}
	}
	
	public Tiempos dtoToEntity(TiempoCreateDTO tiempoDTO) {
		Tiempos tiempos = new Tiempos();
		tiempos.setId(tiempoDTO.getId());
		tiempos.setHoras(tiempoDTO.getHoras());
		
		if(tiempoDTO.getDestino()!=null) {
			Optional<Aeropuerto> aero = aeropuertosDao.findById(tiempoDTO.getDestino());
			if(aero.isPresent()) {
				tiempos.setDestino(aero.get());
			}
		}
		if(tiempoDTO.getOrigen()!=null) {
			Optional<Aeropuerto> aero = aeropuertosDao.findById(tiempoDTO.getOrigen());
			if(aero.isPresent()) {
				tiempos.setOrigen(aero.get());
			}
		}
		return tiempos;
	}

	public TiempoListDTO entityToDto(Tiempos tiempos) {
		TiempoListDTO tiempoDto = new TiempoListDTO();
		tiempoDto.setId(tiempos.getId());
		tiempoDto.setHoras(tiempos.getHoras());
		if(tiempos.getDestino()!=null) {
			AeropuertoNombres aeroND = new AeropuertoNombres();
			aeroND.setId(tiempos.getDestino().getId());
			aeroND.setNombre(tiempos.getDestino().getNombre());
			tiempoDto.setDestino(aeroND);
		}

		if(tiempos.getOrigen()!=null) {	 
			AeropuertoNombres aeroNO = new AeropuertoNombres();
			aeroNO.setId(tiempos.getOrigen().getId());
			aeroNO.setNombre(tiempos.getOrigen().getNombre());
			tiempoDto.setOrigen(aeroNO);
		}

		return tiempoDto;
	}
}