package edu.ifsp.ifpizza.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Cliente {
	
	private long id;
	private String nome;
	private String agendamento_id;
}
