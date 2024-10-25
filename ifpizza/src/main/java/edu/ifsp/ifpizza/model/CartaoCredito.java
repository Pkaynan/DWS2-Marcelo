package edu.ifsp.ifpizza.model;

import org.hibernate.validator.constraints.CreditCardNumber;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString(exclude = "pedido")
@Table(name = "cartao")
public class CartaoCredito {

	@Id
	@Column(name = "pedido_id")
	private Long id;

	@NotBlank(message = "Informe um número de cartão")
	// @CreditCardNumber
	private String numero;

	@Digits(integer = 3, fraction = 0, message = "Informe o CVV com 3 dígitos")
	private String cvv;

	@Pattern(regexp = "\\d{2}/\\d{2}", message = "Informe a expiração no formato mm/aa")
	private String expiracao;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
}
