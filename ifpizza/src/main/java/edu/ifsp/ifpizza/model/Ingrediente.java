package edu.ifsp.ifpizza.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity
public class Ingrediente {

	@Id
	private final String id;
	private final String nome;
	private final Tipo tipo;

	public enum Tipo {
		BORDA, PROTEINA, VEGETAIS, QUEIJO
	}

}