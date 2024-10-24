package edu.ifsp.ifpizza.data;

import java.util.List;

import edu.ifsp.ifpizza.model.Cliente;

public interface ClienteRepositorio {
	List<Cliente> listarCliente();
	Cliente find(String id);
	Cliente save(Cliente cliente);
}
