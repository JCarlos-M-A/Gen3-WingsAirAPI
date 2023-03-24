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

import com.wingsair.app.dtos.PilotoCreateDTO;
import com.wingsair.app.dtos.PilotoListDTO;
import com.wingsair.app.dtos.TiempoCreateDTO;
import com.wingsair.app.dtos.TiempoListDTO;
import com.wingsair.app.services.IService;

@RestController
@RequestMapping("/api/tiempos")
@CrossOrigin(origins = "*")
public class CTiempos {

	@Autowired
	private IService<TiempoListDTO, TiempoCreateDTO> tiemposService;
	
	@GetMapping
	public List<TiempoListDTO> getListaTiempo(){
		return tiemposService.getAll();
	}
	
	@PostMapping
	public TiempoListDTO guardarTiempo(@RequestBody TiempoCreateDTO tiempoDTO) {
		return tiemposService.create(tiempoDTO);
	}
	
	@GetMapping("/{id}")
	public TiempoListDTO getTiempoById(@PathVariable(name = "id") long id) {
		return tiemposService.getById(id);
	}
	
	@PutMapping("/{id}")
	public TiempoListDTO actualizarTiempo(@RequestBody TiempoCreateDTO tiempoDTO, 
			@PathVariable(name = "id") long id) {
		TiempoListDTO tiempoRespuesta = tiemposService.update(tiempoDTO, id);
		return tiempoRespuesta;
	}
	
	@DeleteMapping("/{id123}")
	public Map<String, String> eliminarTiempo(@PathVariable(name="id123") long id) {
		Map<String, String> mapa = new HashMap<>();
		tiemposService.delete(id);
		mapa.put("message", "Tiempos eliminado");
		return mapa;
	}
}
