package edu.ifsp.ifpizza.data;

import org.springframework.data.repository.CrudRepository;

import edu.ifsp.ifpizza.model.Ingrediente;

public interface IngredienteRepositorio extends CrudRepository<Ingrediente, String>{
	
}
