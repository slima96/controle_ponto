package com.dio.controle_de_ponto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.controle_de_ponto.model.Empresa;
import com.dio.controle_de_ponto.repositories.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;
	
	public List<Empresa> findAll(){
		List<Empresa> list = repository.findAll();
		
		return list;
	}
	
	public Empresa findById(Long id) throws Exception {
		Optional<Empresa> obj = repository.findById(id);
		
		Empresa entity = obj.orElseThrow(() -> new IllegalArgumentException("Empresa não encontrada"));
		return entity;
	}
	
	public Empresa insert(Empresa obj) {
		
		return repository.save(obj);
	}
	
	public Empresa update(Long id, Empresa obj) {
		Empresa entity = repository.getOne(id);
		copyToEntity(obj, entity);
		entity = repository.save(entity);	
		
		return entity;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	private void copyToEntity(Empresa obj, Empresa entity) {
		entity.setDescricao(obj.getDescricao());
		entity.setCnpj(obj.getCnpj());
		entity.setEndereco(obj.getEndereco());
		entity.setBairro(obj.getBairro());
		entity.setCidade(obj.getCidade());
		entity.setEstado(obj.getEstado());
		entity.setTelefone(obj.getTelefone());
	}
}
