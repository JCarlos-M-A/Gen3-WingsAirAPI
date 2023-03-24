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

import com.wingsair.app.dtos.AeropuertoCreateDTO;
import com.wingsair.app.dtos.AeropuertoListDTO;
import com.wingsair.app.services.IService;

@RestController
@RequestMapping("/api/aeropuertos")
@CrossOrigin(origins = "*")
public class CAeropueros {
	
	@Autowired
	private IService<AeropuertoListDTO, AeropuertoCreateDTO> aeropuertoService;
	
	@GetMapping
	public List<AeropuertoListDTO> getListaAeropuertos(){
		return aeropuertoService.getAll();
	}
	
	@PostMapping
	public AeropuertoListDTO guardarAeropuerto(@RequestBody AeropuertoCreateDTO aeropuertoDTO) {
		return aeropuertoService.create(aeropuertoDTO);
	}
	
	@GetMapping("/{id}")
	public AeropuertoListDTO getAeropuertoById(@PathVariable(name = "id") long id) {
		return aeropuertoService.getById(id);
	}
	
	@PutMapping("/{id}")
	public AeropuertoListDTO actualizarAeropuerto(@RequestBody AeropuertoCreateDTO aeroDTO, 
			@PathVariable(name = "id") long id) {
		AeropuertoListDTO aeroRespuesta = aeropuertoService.update(aeroDTO, id);
		return aeroRespuesta;
	}
	
	@DeleteMapping("/{id123}")
	public Map<String, String> eliminarAvion(@PathVariable(name="id123") long id) {
		Map<String, String> mapa = new HashMap<>();
		aeropuertoService.delete(id);
		mapa.put("message", "Aeropuerto eliminado");
		return mapa;
	}
}
