package edu.ifsp.ifpizza.model;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Pizza {
	private Long id;
	private Date dataCriacao;
	
	@NotNull
	@Size(min = 5, message = "Deve conter, no mínimo, 5 caracteres.")
	private String nome;
	
	@Size(min = 1, message = "Você deve escolher, pelo menos, 1 ingrediente.")
	private List<Ingrediente> ingredientes;
}
