package com.wingsair.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wingsair.app.dtos.AvionCreateDTO;
import com.wingsair.app.dtos.AvionListDTO;
import com.wingsair.app.dtos.PilotoCreateDTO;
import com.wingsair.app.dtos.PilotoListDTO;
import com.wingsair.app.services.IService;

@RestController
@RequestMapping("/api/pilotos")
@CrossOrigin(origins = "*")
public class CPiloto {
	
	@Autowired
	private IService<PilotoListDTO, PilotoCreateDTO> pilotosService;
	
	@GetMapping
	public List<PilotoListDTO> getListaPilotos(){
		return pilotosService.getAll();
	}
	
	@PostMapping
	public PilotoListDTO guardarPiloto(@RequestBody PilotoCreateDTO pilotoDTO) {
		return pilotosService.create(pilotoDTO);
	}
	
	@GetMapping("/{id}")
	public PilotoListDTO getPilotoById(@PathVariable(name = "id") long id) {
		return pilotosService.getById(id);
	}
	
	@PutMapping("/{id}")
	public PilotoListDTO actualizarPiloto(@RequestBody PilotoCreateDTO pilotoDTO, 
			@PathVariable(name = "id") long id) {
		PilotoListDTO pilotoRespuesta = pilotosService.update(pilotoDTO, id);
		return pilotoRespuesta;
	}
	
	@DeleteMapping("/{id123}")
	public Map<String, String> eliminarPiloto(@PathVariable(name="id123") long id) {
		Map<String, String> mapa = new HashMap<>();
		pilotosService.delete(id);
		mapa.put("message", "Piloto eliminado");
		return mapa;
	}
}
