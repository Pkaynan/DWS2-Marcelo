package edu.ifsp.ifpizza.data;

import edu.ifsp.ifpizza.model.Ingrediente;

public interface IngredienteRepositorio {
	Ingrediente find(String id);
	Iterable<Ingrediente> findAll();
	Ingrediente save(Ingrediente ingrediente);

}
