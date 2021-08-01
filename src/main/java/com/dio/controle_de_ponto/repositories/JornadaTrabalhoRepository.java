package com.dio.controle_de_ponto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dio.controle_de_ponto.model.JornadaTrabalho;

@Repository
public interface JornadaTrabalhoRepository extends JpaRepository<JornadaTrabalho, Long>{

}
