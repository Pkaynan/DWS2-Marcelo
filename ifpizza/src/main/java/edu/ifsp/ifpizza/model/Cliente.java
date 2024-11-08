package edu.ifsp.ifpizza.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "cliente")
@ToString(exclude = "agendamento")
public class Cliente {

	@Id
	@Column(name = "cliente_id")
	private Long id_cliente;
	
	@NotBlank
	private String nome_cliente;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String telefone;
	
	@OneToMany(mappedBy = "clientes")
	private List<Agendamento> agendamentos = new ArrayList<>();
	
	
}
