package edu.ifsp.agendamento.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
public class Agendamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Informe uma data")
	@Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Informe uma data no formato dd/mm/aaaa")
	private String data;
	
	@NotBlank(message = "Informe um horário")
	@Pattern(regexp = "\\d{2}:\\d{2}", message = "Informe um horário no formato hh:mm")
	private String hora;
	
	@NotBlank(message = "Informe uma descrição")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
}
