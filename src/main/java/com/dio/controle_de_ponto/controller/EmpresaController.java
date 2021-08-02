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

import com.dio.controle_de_ponto.model.Empresa;
import com.dio.controle_de_ponto.services.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaService service;
	
	@GetMapping
	public List<Empresa> findAll(){
		List<Empresa> list = service.findAll();
		
		return list;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Empresa> findById(@PathVariable Long id) throws Exception {
		Empresa obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public Empresa insert(@RequestBody Empresa obj){
		Empresa entity = service.insert(obj);
		
		return entity;
	}
	
	@PutMapping(value = "/{id}")
	public Empresa update (@PathVariable Long id, @RequestBody Empresa obj) {
		Empresa entity = service.update(id, obj);
		
		return entity;
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Empresa> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
