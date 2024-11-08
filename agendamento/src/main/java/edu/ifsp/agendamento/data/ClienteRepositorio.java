package edu.ifsp.agendamento.data;

import org.springframework.data.repository.CrudRepository;

import edu.ifsp.agendamento.model.Cliente;

public interface ClienteRepositorio extends CrudRepository<Cliente, Long> {
	
}
