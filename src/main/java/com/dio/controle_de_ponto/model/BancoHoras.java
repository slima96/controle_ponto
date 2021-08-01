package com.dio.controle_de_ponto.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "tb_banco_hora")
public class BancoHoras {

	@AllArgsConstructor
	@NoArgsConstructor
	@EqualsAndHashCode
	@Embeddable
	public class BancoHorasId implements Serializable {
		private static final long serialVersionUID = 1L;
		
		private Long idBancoHoras;
		private Long idMovimento;
		private Long idUsuario;
	}
	
	@EmbeddedId
	private BancoHorasId id;
	private LocalDateTime dataTrabalhada;
	private BigDecimal quantidadeHorasTrabalhadas;
	private BigDecimal saldoHoras;
}
