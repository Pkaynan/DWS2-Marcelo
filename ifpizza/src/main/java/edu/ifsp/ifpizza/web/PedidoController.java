package edu.ifsp.ifpizza.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import edu.ifsp.ifpizza.data.PedidoRepositorio;
import edu.ifsp.ifpizza.model.Pedido;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/pedidos")
@SessionAttributes("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepositorio pedidoRepo;

	@ModelAttribute(name = "pedido")
	public Pedido pedido() {
		return new Pedido();
	}
	
	@GetMapping("/atual")
	public String pedidoForm() {
		return "pedido-form";
	}
	
	@PostMapping
	public String processar(@Valid Pedido pedido, Errors errors, SessionStatus sessionStatus) {
		if (errors.hasErrors()) {
			return "pedido-form";
		}
		pedidoRepo.save(pedido);
		sessionStatus.setComplete();
		log.info("Processando pedido: " + pedido);
		
		
		return "redirect:/";
	}	
}
