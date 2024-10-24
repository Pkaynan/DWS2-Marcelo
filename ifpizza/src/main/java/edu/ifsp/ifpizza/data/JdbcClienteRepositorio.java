package edu.ifsp.ifpizza.data;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.ifsp.ifpizza.model.Cliente;

@Repository
public class JdbcClienteRepositorio implements ClienteRepositorio{
	
	private JdbcTemplate jdbc;
	
	public JdbcClienteRepositorio (JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public List<Cliente> listarCliente() {

	}

	@Override
	public Cliente find(String id) {
		return jdbc.queryForObject("select cliente_id, nome, agendamento_id, ", null);
	}

	@Override
	public Cliente save(Cliente cliente) {
		jdbc.update(
				"insert into ingrediente(id, nome, agendamento) values (?, ?, ?)",
				cliente.getId(),
				cliente.getNome(),
				cliente.getAgenddamentoID().toString());
		return cliente;
	}

}
