package com.dio.controle_de_ponto.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Audited
@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private BigDecimal tolerancia;
	private LocalDateTime inicioJornada;
	private LocalDateTime finalJornada;
	
	@ManyToOne
	private CategoriaUsuario categoriaUsuario;
	
	@ManyToOne
	private Empresa empresa;
	
	@ManyToOne
	private NivelAcesso nivelAcesso;
	
	@ManyToOne
	private JornadaTrabalho jornadaTrabalho;
	
}
