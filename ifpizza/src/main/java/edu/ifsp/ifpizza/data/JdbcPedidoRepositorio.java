package edu.ifsp.ifpizza.data;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import edu.ifsp.ifpizza.model.Pedido;
import edu.ifsp.ifpizza.model.Pizza;

@Repository
public class JdbcPedidoRepositorio implements PedidoRepositorio{

	private SimpleJdbcInsert pedidoInserter;
	private SimpleJdbcInsert pizzaInserter;
	
	public JdbcPedidoRepositorio(JdbcTemplate jdbc) {
		pedidoInserter = new SimpleJdbcInsert(jdbc).withTableName("pedido").usingGeneratedKeyColumns("id");
	}
	
	@Override
	public Pedido save(Pedido pedido) {
		pedido.setDataCriacao(new Date());
		long pedidoId = savePedido(pedido);
		pedido.setId(pedidoId);
		for(Pizza pizza : pedido.getPizzas()) {
			savePizza(pizza.getId(), pedidoId);
		}
		return null;
	}
	
	public void savePizza(Long id, long pedidoId) {
		Map<String , Object> values = new HashMap<>();
		values.put("pizza_id", id);
		values.put("pedido_id", pedidoId);
		
		pizzaInserter.execute(values);
	}
	
	private long savePedido(Pedido pedido){
		Map<String , Object> values = new HashMap<>();
		values.put("data",new Timestamp(pedido.getDataCriacao().getTime()));
		values.put("nome", pedido.getNome());
		values.put("endereco", pedido.getEndereco());
		values.put("cidade", pedido.getCidade());
		values.put("estado", pedido.getEstado());
		values.put("cep",pedido.getCep() );
		
		long pedidoId = pedidoInserter.executeAndReturnKey(values).longValue();
		
		return pedidoId;
	}

}
