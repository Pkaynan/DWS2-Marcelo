package edu.ifsp.ifpizza.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.ifsp.ifpizza.model.Ingrediente;

@Repository
public class JdbcIngredienteRepositorio implements IngredienteRepositorio {
	private JdbcTemplate jdbc;
	
	public JdbcIngredienteRepositorio(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	@Override
	public Ingrediente save(Ingrediente ingrediente) {
		// TODO Auto-generated method stub;
		return null;
	}

	@Override
	public Ingrediente find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Ingrediente> findAll() {
		return jdbc.query("select id, nome, tipo from ingrediente", this::mapRow);
	}
	
	private Ingrediente mapRow(ResultSet rs, int rowNum)throws SQLException{
		return new Ingrediente(
				rs.getString("id"),
				rs.getString("nome"),
				Ingrediente.Tipo.valueOf(rs.getString("tipo")));
	}

}
