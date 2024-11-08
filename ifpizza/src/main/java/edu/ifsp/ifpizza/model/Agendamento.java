package edu.ifsp.ifpizza.model;

import java.math.BigInteger;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "agendamento")
public class Agendamento {

	@Id
	@Column(name = "agendamento_id")
	private Long id_agendamento;
	
	private String descricao;
	
	private LocalDateTime data_hora = LocalDateTime.now();
	
	@ManyToOne
	@MapsId
	@JoinColumn(name = "cliente_id")
	private Cliente clientes;
	
}
