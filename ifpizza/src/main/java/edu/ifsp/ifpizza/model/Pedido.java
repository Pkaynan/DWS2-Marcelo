package edu.ifsp.ifpizza.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "data")
	private Date dataCriacao;
	
	@ManyToMany(targetEntity = Pizza.class)
	@JoinTable(name = "pizza_pedido",
			joinColumns = @JoinColumn(name = "pedido_id"),
			inverseJoinColumns = @JoinColumn(name = "pizza_id"))
	private List<Pizza> pizzas = new ArrayList<>();
	
	@NotBlank(message = "Informe um nome")
	private String nome;
	
	@NotBlank(message = "Informe um endereço")
	private String endereco;
	
	@NotBlank(message = "Informe uma cidade")
	private String cidade;
	
	@NotBlank(message = "Informe a sigla do estado")
	@Size(min = 2, max = 2, message = "A sigla deve ser formada por duas letras")
	@Column(columnDefinition = "CHAR(2)")
	private String estado;
	
	@Pattern(regexp = "\\d{5}-\\d{3}", message = "Informe o CEP no formato 99999-999")
	private String cep;
	
	@PrePersist
	void realizadoEm() {
		dataCriacao = new Date();
	}

	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	@Valid
	private CartaoCredito cartao; 
	
	public void setCartao(CartaoCredito cartao) {
		cartao.setPedido(this);			
		this.cartao = cartao;
	}
		
	public void add(Pizza pizza) {
		pizzas.add(pizza);
	}
}
