package edu.ifsp.ifpizza.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Pedido {
	private Long id;
	private Date dataCriacao;
	private List<Pizza> pizzas = new ArrayList<>();
	
	@NotBlank(message = "Informe um nome")
	private String nome;
	
	@NotBlank(message = "Informe um endereço")
	private String endereco;
	
	@NotBlank(message = "Informe uma cidade")
	private String cidade;
	
	@NotBlank(message = "Informe a sigla do estado")
	@Size(min = 2, max = 2, message = "A sigla deve ser formada por duas letras")
	private String estado;
	
	@Pattern(regexp = "\\d{5}-\\d{3}", message = "Informe o CEP no formato 99999-999")
	private String cep;
	
	@NotBlank(message = "Informe um número de cartão")
	//@CreditCardNumber
	private String cartaoNumero;
	
	@Digits(integer = 3, fraction = 0, message = "Informe o CVV com 3 dígitos")
	private String cartaoCVV;
	
	@Pattern(regexp = "\\d{2}/\\d{2}", message = "Informe a expiração no formato mm/aaaa")
	private String cartaoExpiracao;
	
	public void add(Pizza pizza) {
		pizzas.add(pizza);
	}
}
