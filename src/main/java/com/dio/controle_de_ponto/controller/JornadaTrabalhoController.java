package com.dio.controle_de_ponto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.controle_de_ponto.model.JornadaTrabalho;
import com.dio.controle_de_ponto.services.JornadaTrabalhoService;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

	@Autowired
	private JornadaTrabalhoService service;
	
	@GetMapping
	public List<JornadaTrabalho> findAll(){
		List<JornadaTrabalho> list = service.findAll();
		
		return list;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<JornadaTrabalho> findById(@PathVariable Long id) throws Exception {
		JornadaTrabalho obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public JornadaTrabalho insert(@RequestBody JornadaTrabalho obj){
		JornadaTrabalho entity = service.insert(obj);
		
		return entity;
	}
	
	@PutMapping(value = "/{id}")
	public JornadaTrabalho update (@PathVariable Long id, @RequestBody JornadaTrabalho obj) {
		JornadaTrabalho entity = service.update(id, obj);
		
		return entity;
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<JornadaTrabalho> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
