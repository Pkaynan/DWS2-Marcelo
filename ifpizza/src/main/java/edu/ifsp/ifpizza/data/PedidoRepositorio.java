package edu.ifsp.ifpizza.data;

import org.springframework.data.repository.CrudRepository;

import edu.ifsp.ifpizza.model.Pedido;

public interface PedidoRepositorio extends CrudRepository<Pedido, Long> {

}
