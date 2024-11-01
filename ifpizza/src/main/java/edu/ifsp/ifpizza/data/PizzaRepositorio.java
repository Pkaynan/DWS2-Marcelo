package edu.ifsp.ifpizza.data;

import org.springframework.data.repository.CrudRepository;

import edu.ifsp.ifpizza.model.Pizza;

public interface PizzaRepositorio extends CrudRepository<Pizza, Long> {

}
