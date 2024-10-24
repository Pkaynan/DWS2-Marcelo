package edu.ifsp.ifpizza.model;

import java.sql.Date;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Agendamento {
	
	
	private long idAgendamento;
	private String descricao;
	private Date data_hora;
}
