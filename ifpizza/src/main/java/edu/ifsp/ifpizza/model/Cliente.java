package edu.ifsp.ifpizza.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Cliente {
	
	private String nome;
	private String id;
	private String agenddamentoID;
	
}
