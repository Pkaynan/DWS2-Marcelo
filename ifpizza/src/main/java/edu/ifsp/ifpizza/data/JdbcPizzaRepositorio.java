package edu.ifsp.ifpizza.data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import edu.ifsp.ifpizza.model.Ingrediente;
import edu.ifsp.ifpizza.model.Pizza;

@Repository
public class JdbcPizzaRepositorio implements PizzaRepositorio {

	private JdbcTemplate jdbc;
	private SimpleJdbcInsert pizzaInserter;
	
	public JdbcPizzaRepositorio(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
		pizzaInserter = new SimpleJdbcInsert(jdbc)
				.withTableName("pizza")
				.usingGeneratedKeyColumns("id");
	}
	
	@Override
	public Pizza save(Pizza nova) {
		long id = savePizza(nova);
		nova.setId(id);
		for (Ingrediente ingrediente : nova.getIngredientes()) {
			saveIngrediente(ingrediente, id);
		}
		
		return nova;
	}

	private long savePizza(Pizza pizza) {
		pizza.setDataCriacao(new Date());
		Map<String, Object> values = new HashMap<>();
		values.put("nome", pizza.getNome());
		values.put("data_criacao", pizza.getDataCriacao());
		
		long pizzaId = pizzaInserter.executeAndReturnKey(values).longValue();
		
		return pizzaId;
	}

	private void saveIngrediente(Ingrediente ingrediente, long pizzaId) {
		jdbc.update(
				"insert into pizza_ingrediente (pizza_id, ingrediente_id) values (?, ?)",
				pizzaId, ingrediente.getId());
	}
	
}
