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
public class JdbcPizzaRepositorio implements PizzaRepositorio{
	private SimpleJdbcInsert pizzaInserter;
	private SimpleJdbcInsert ingredienteInserter;
	
	public JdbcPizzaRepositorio(JdbcTemplate jdbc) {
		pizzaInserter = new SimpleJdbcInsert(jdbc).withTableName("pizza").usingGeneratedKeyColumns("id");
		
		ingredienteInserter = new SimpleJdbcInsert(jdbc).withTableName("pizza_ingrediente");
	}

	@Override
	public Pizza save(Pizza pizza) {
		pizza.setDataCriacao(new Date());
		long id = savePizza(pizza);
		for(Ingrediente ingrediente : pizza.getIngredientes()) {
			saveingrediente(ingrediente, id);
		}
		return pizza;
	}

	private void saveingrediente(Ingrediente ingrediente, long id) {
		Map<String, Object> values = new HashMap<>();
		values.put("pizza_id", id);
		values.put("ingrediente_id", ingrediente.getId());
		
		ingredienteInserter.execute(values);
	}

	private long savePizza(Pizza pizza) {
		Map<String,Object> values = new HashMap<>();
		values.put("nome", pizza.getNome());
		values.put("data_criacao", pizza.getDataCriacao());
		
		long id = pizzaInserter.executeAndReturnKey(values).longValue();
		
		return id;
	}

}
