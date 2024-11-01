package edu.ifsp.ifpizza.model;

import java.math.BigInteger;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MapsId;
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
	@Column(name = "id_cliente")
	private BigInteger id_cliente;
	
	@NotBlank
	private String nome_cliente;
	
	@ManyToMany
	@JoinTable(name = "cliente_agendamento", joinColumns =  @JoinColumn(name = "id_cliente"), inverseJoinColumns = @JoinColumn(name = "id_agendamento"))
	@MapsId
	private Agendamento agendamento;
	
	
}
