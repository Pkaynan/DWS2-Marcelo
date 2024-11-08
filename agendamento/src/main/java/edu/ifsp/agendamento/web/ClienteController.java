package edu.ifsp.agendamento.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.ifsp.agendamento.data.ClienteRepositorio;
import edu.ifsp.agendamento.model.Cliente;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/cadastro")
@SessionAttributes("cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepositorio clienteRepo;
	
	@ModelAttribute
	public Cliente cliente() {
		return new Cliente();
	}
	
	@GetMapping
	public String formCadastro() {
		return "cadastro";
	}
	
	@PostMapping
	public String processar(@Valid Cliente cliente, Errors errors) {
		
		if(errors.hasErrors()) {
			return "cadastro";
		}
		
		clienteRepo.save(cliente);
		
		log.info("Dados Cliente: " + cliente);
		return "redirect:/agendamento";
	}
}
