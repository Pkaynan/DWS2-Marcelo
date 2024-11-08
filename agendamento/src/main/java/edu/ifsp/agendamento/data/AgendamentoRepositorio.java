package edu.ifsp.agendamento.data;

import org.springframework.data.repository.CrudRepository;

import edu.ifsp.agendamento.model.Agendamento;

public interface AgendamentoRepositorio extends CrudRepository<Agendamento, Long> {
	
}
