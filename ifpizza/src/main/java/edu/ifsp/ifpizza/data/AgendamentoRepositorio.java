package edu.ifsp.ifpizza.data;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import edu.ifsp.ifpizza.model.Agendamento;

public interface AgendamentoRepositorio extends CrudRepository<Agendamento, Long>{

}
