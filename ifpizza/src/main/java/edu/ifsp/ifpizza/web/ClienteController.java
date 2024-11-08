package edu.ifsp.ifpizza.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.ifsp.ifpizza.data.ClienteRepositorio;
import edu.ifsp.ifpizza.model.Cliente;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/cliente")
@Slf4j
@SessionAttributes("cliente")
public class ClienteController {

	@Autowired
	private ClienteRepositorio cliente;
	
	@ModelAttribute("cliente")
	public Cliente Objcliente() {
		return new Cliente();
	}
	
	public String clienteform() {
		return "cadastro-form";
	}
}
