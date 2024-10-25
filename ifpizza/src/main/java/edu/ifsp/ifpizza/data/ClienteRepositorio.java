package edu.ifsp.ifpizza.data;

import edu.ifsp.ifpizza.model.Cliente;

public interface ClienteRepositorio {

	Cliente find(String id);
	Cliente save(Cliente cliente);
}
