package com.wingsair.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wingsair.app.dao.IAvionDao;
import com.wingsair.app.dtos.AvionCreateDTO;
import com.wingsair.app.dtos.AvionListDTO;
import com.wingsair.app.enums.Tipos;
import com.wingsair.app.models.Avion;

@Component
public class avionesService implements IService<AvionListDTO, AvionCreateDTO>{

	@Autowired
	private IAvionDao avionesDao;
	
	@Override
	public AvionListDTO create(AvionCreateDTO obj) {
		Avion avion = this.dtoToEntity(obj);
		Avion avionNueva = avionesDao.save(avion);
		return this.entityToDto(avionNueva);
	}

	@Override
	public List<AvionListDTO> getAll() {
		List<AvionListDTO> listaDTO = new ArrayList<>();
		List<Avion> lista = avionesDao.findAll();
		for (Avion avion : lista) {
			listaDTO.add(this.entityToDto(avion));
		}
		return listaDTO;
	}

	@Override
	public AvionListDTO getById(long id) {
		Avion avion = avionesDao.findById(id).orElseThrow(() -> new RuntimeException());
		return this.entityToDto(avion);
	}

	@Override
	public AvionListDTO update(AvionCreateDTO obj, long id) {
		Avion avion = avionesDao.findById(id).orElseThrow(() -> new RuntimeException());
		avion.setId(obj.getId());
		avion.setCapacidad(obj.getCapacidad());
		avion.setCodigo(obj.getCodigo());
		avion.setHoras(obj.getHoras());
		avion.setTipoAvion(Tipos.getFromString(obj.getTipoAvion()));
		
		Avion avionActual = avionesDao.save(avion);
		return this.entityToDto(avionActual);
	}

	@Override
	public void delete(long id) {
		Optional<Avion> avion = avionesDao.findById(id);
		if(avion.isPresent()) {
			avionesDao.delete(avion.get());
		}else {
			
		}
	}
	
	public Avion dtoToEntity(AvionCreateDTO avionDTO) {
		Avion avion = new Avion();
		avion.setId(avionDTO.getId());
		avion.setCapacidad(avionDTO.getCapacidad());
		avion.setCodigo(avionDTO.getCodigo());
		avion.setHoras(avionDTO.getHoras());
		avion.setTipoAvion(Tipos.getFromString(avionDTO.getTipoAvion()));

		return avion;
	}
	
	public AvionListDTO entityToDto(Avion avion) {
		AvionListDTO avionDto = new AvionListDTO();
		avionDto.setId(avion.getId());
		avionDto.setCapacidad(avion.getCapacidad());
		avionDto.setCodigo(avion.getCodigo());
		avionDto.setHoras(avion.getHoras());
		avionDto.setTipoAvion(avion.getTipoAvion().getDescripcion());

		return avionDto;
	}

}
