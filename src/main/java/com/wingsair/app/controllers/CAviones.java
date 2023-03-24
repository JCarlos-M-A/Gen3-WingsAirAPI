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
import com.wingsair.app.services.IService;

@RestController
@RequestMapping("/api/aviones")
@CrossOrigin(origins = "*")
public class CAviones {
	
	@Autowired
	private IService<AvionListDTO, AvionCreateDTO> avionesService;
	
	@GetMapping
	public List<AvionListDTO> getListaAviones(){
		return avionesService.getAll();
	}
	
	@PostMapping
	public AvionListDTO guardarAvion(@RequestBody AvionCreateDTO avionDTO) {
		return avionesService.create(avionDTO);
	}
	
	@GetMapping("/{id}")
	public AvionListDTO getAvionById(@PathVariable(name = "id") long id) {
		return avionesService.getById(id);
	}
	
	@PutMapping("/{id}")
	public AvionListDTO actualizarAvion(@RequestBody AvionCreateDTO avionDTO, 
			@PathVariable(name = "id") long id) {
		AvionListDTO avionRespuesta = avionesService.update(avionDTO, id);
		return avionRespuesta;
	}
	
	@DeleteMapping("/{id123}")
	public Map<String, String> eliminarAvion(@PathVariable(name="id123") long id) {
		Map<String, String> mapa = new HashMap<>();
		avionesService.delete(id);
		mapa.put("message", "Avion eliminado");
		return mapa;
	}
}
