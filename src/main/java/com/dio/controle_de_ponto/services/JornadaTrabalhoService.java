package com.dio.controle_de_ponto.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.controle_de_ponto.model.JornadaTrabalho;
import com.dio.controle_de_ponto.repositories.JornadaTrabalhoRepository;

@Service
public class JornadaTrabalhoService {

	@Autowired
	private JornadaTrabalhoRepository repository;
	
	public List<JornadaTrabalho> findAll(){
		List<JornadaTrabalho> list = repository.findAll();
		
		return list;
	}
	
	public JornadaTrabalho findById(Long id) throws Exception {
		Optional<JornadaTrabalho> obj = repository.findById(id);
		
		JornadaTrabalho entity = obj.orElseThrow(() -> new IllegalArgumentException("Jornada não encontrada"));
		return entity;
	}
	
	public JornadaTrabalho insert(JornadaTrabalho obj) {
		
		return repository.save(obj);
	}
	
	@Transactional
	public JornadaTrabalho update(Long id, JornadaTrabalho obj) {
		JornadaTrabalho entity = repository.getOne(id);
		
		entity.setDescricao(obj.getDescricao());
		
		entity = repository.save(entity);
		
		return entity;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
