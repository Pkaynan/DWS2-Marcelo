package edu.ifsp.ifpizza.model;

import java.math.BigInteger;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "agendamento")
public class Agendamento {

	private BigInteger id_agendamento;
	private String descricao;
	private LocalDateTime dataHora = LocalDateTime.now();
	
	
}
