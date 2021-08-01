package com.dio.controle_de_ponto.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "tb_movimentacao")
public class Movimentacao {
	
	@AllArgsConstructor
	@NoArgsConstructor
	@EqualsAndHashCode
	@Embeddable
	public class MovimentacaoId implements Serializable {
		private static final long serialVersionUID = 1L;
		
		private Long idMovimento;
		private Long idUsuario;
	}

	@EmbeddedId
	private MovimentacaoId id;
	private LocalDateTime dataEntrada;
	private LocalDateTime dataSaida;
	private BigDecimal periodo;
	
	@ManyToOne
	private Ocorrencia ocorrencia;
	
	@ManyToOne
	private Calendario calendario;
	
}
