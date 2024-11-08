package edu.ifsp.ifpizza.data;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import edu.ifsp.ifpizza.model.Cliente;

public interface ClienteRepositorio extends CrudRepository<Cliente, Long>{

}
