package edu.ifsp.ifpizza.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dataCriacao;

	@NotNull
	@Size(min = 5, message = "Deve conter, no mínimo, 5 caracteres.")
	private String nome;

	@ManyToMany
	@JoinTable(name = "pizza_ingrediente", joinColumns = @JoinColumn(name = "pizza_id"), inverseJoinColumns = @JoinColumn(name = "ingrediente_id"))
	@Size(min = 1, message = "Você deve escolher, pelo menos, 1 ingrediente.")
	private List<Ingrediente> ingredientes;

	@PrePersist
	void criadoEm() {
		dataCriacao = new Date();
	}
}
