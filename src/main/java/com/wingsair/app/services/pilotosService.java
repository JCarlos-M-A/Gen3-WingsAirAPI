package com.wingsair.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wingsair.app.dao.IPilotosDao;
import com.wingsair.app.dtos.PilotoCreateDTO;
import com.wingsair.app.dtos.PilotoListDTO;
import com.wingsair.app.enums.Sexo;
import com.wingsair.app.models.Piloto;

@Component
public class pilotosService implements IService<PilotoListDTO, PilotoCreateDTO>{

	@Autowired
	private IPilotosDao pilotosDao;
	
	@Override
	public PilotoListDTO create(PilotoCreateDTO obj) {
		Piloto piloto = this.dtoToEntity(obj);
		Piloto pilotoNuevo = pilotosDao.save(piloto);
		return this.entityToDto(pilotoNuevo);
	}

	@Override
	public List<PilotoListDTO> getAll() {
		List<PilotoListDTO> listaDTO = new ArrayList<>();
		List<Piloto> lista = pilotosDao.findAll();
		for (Piloto piloto : lista) {
			listaDTO.add(this.entityToDto(piloto));
		}
		return listaDTO;
	}

	@Override
	public PilotoListDTO getById(long id) {
		Piloto piloto = pilotosDao.findById(id).orElseThrow(() -> new RuntimeException());
		return this.entityToDto(piloto);
	}

	@Override
	public PilotoListDTO update(PilotoCreateDTO obj, long id) {
		Piloto piloto = pilotosDao.findById(id).orElseThrow(() -> new RuntimeException());
		piloto.setId(obj.getId());
		piloto.setNombre(obj.getNombre());
		piloto.setCodigo(obj.getCodigo());
		piloto.setHoras(obj.getHoras());
		piloto.setSexo(Sexo.getFromString(obj.getSexo()));
		
		Piloto pilotoActual = pilotosDao.save(piloto);
		return this.entityToDto(pilotoActual);
	}

	@Override
	public void delete(long id) {
		Optional<Piloto> piloto = pilotosDao.findById(id);
		if(piloto.isPresent()) {
			pilotosDao.delete(piloto.get());
		}else {
			
		}
	}
	
	public Piloto dtoToEntity(PilotoCreateDTO pilotoDTO) {
		Piloto piloto = new Piloto();
		piloto.setId(pilotoDTO.getId());
		piloto.setCodigo(pilotoDTO.getCodigo());
		piloto.setHoras(pilotoDTO.getHoras());
		piloto.setNombre(pilotoDTO.getNombre());
		piloto.setSexo(Sexo.getFromString(pilotoDTO.getSexo()));

		return piloto;
	}

	public PilotoListDTO entityToDto(Piloto piloto) {
		PilotoListDTO pilotoDto = new PilotoListDTO();
		pilotoDto.setId(piloto.getId());
		pilotoDto.setCodigo(piloto.getCodigo());
		pilotoDto.setHoras(piloto.getHoras());
		pilotoDto.setNombre(piloto.getNombre());
		pilotoDto.setSexo(piloto.getSexo().getDescripcion());

		return pilotoDto;
	}

}
