package edu.ifsp.agendamento.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Informe um nome")
	@Size(min = 5, message = "Nome deve ter no mínimo 5 caracteres.")
	private String nome;
	
	@NotBlank(message = "Informe um endereço")
	private String endereco;
	
	@Pattern(regexp = "\\d{5}-\\d{4}", message = "Informe um telefone no formato: xxxxx-xxxx")
	private String telefone;
	
	@OneToMany(mappedBy = "cliente")
	private List<Agendamento> agendamentos = new ArrayList<>();
	
	public void addAgendamento(Agendamento agendamento) {
		agendamentos.add(agendamento);
	}
}
