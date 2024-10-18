package edu.ifsp.ifpizza.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import edu.ifsp.ifpizza.data.IngredienteRepositorio;
import edu.ifsp.ifpizza.model.Ingrediente;

@Component
public class IngredienteConverte implements Converter<String, Ingrediente>{
	@Autowired
	private IngredienteRepositorio ingredienteRepo;

	@Override
	public Ingrediente convert(String id) {
		return ingredienteRepo.find(id);
	}

}
