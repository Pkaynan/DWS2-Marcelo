package edu.ifsp.ifpizza.data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import edu.ifsp.ifpizza.model.Pedido;
import edu.ifsp.ifpizza.model.Pizza;

@Repository
public class JdbcPedidoRepositorio implements PedidoRepositorio {
	private SimpleJdbcInsert pedidoInserter;
	private SimpleJdbcInsert pedidoPizzaInserter;
	private SimpleJdbcInsert pedidoCartaoInserter;

	public JdbcPedidoRepositorio(JdbcTemplate jdbc) {
		pedidoInserter = new SimpleJdbcInsert(jdbc)
				.withTableName("pedido")
				.usingGeneratedKeyColumns("id");
		
		pedidoPizzaInserter = new SimpleJdbcInsert(jdbc)
				.withTableName("pizza_pedido");
		
		pedidoCartaoInserter = new SimpleJdbcInsert(jdbc)
				.withTableName("cartao");		
	}

	@Override
	public Pedido save(Pedido pedido) {
		pedido.setDataCriacao(new Date());
		long pedidoId = salvarDetalhes(pedido);
		pedido.setId(pedidoId);
		for (Pizza pizza : pedido.getPizzas()) {
			salvarPizzaPedido(pizza, pedidoId);
		}
		return pedido;
	}

	private long salvarDetalhes(Pedido pedido) {
		Map<String, Object> values = new HashMap<>();
		values.put("data", pedido.getDataCriacao());
		values.put("nome", pedido.getDataCriacao());
		values.put("endereco", pedido.getEndereco());
		values.put("cidade", pedido.getCidade());
		values.put("estado", pedido.getEstado());
		values.put("cep", pedido.getCep());

		long id = pedidoInserter.executeAndReturnKey(values).longValue();
		
		Map<String, Object> cartao = new HashMap<>();
		cartao.put("pedido_id", id);;
		cartao.put("numero", pedido.getCartaoNumero());
		cartao.put("expiracao", pedido.getCartaoExpiracao());
		cartao.put("cvv", pedido.getCartaoCVV());
		pedidoCartaoInserter.execute(cartao);
		
		return id;
	}

	private void salvarPizzaPedido(Pizza pizza, long pedidoId) {
		Map<String, Object> values = new HashMap<>();
		values.put("pizza_id", pizza.getId());
		values.put("pedido_id", pedidoId);
		pedidoPizzaInserter.execute(values);
	}

	
}
