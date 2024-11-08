package edu.ifsp.agendamento.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import edu.ifsp.agendamento.data.AgendamentoRepositorio;
import edu.ifsp.agendamento.model.Agendamento;
import edu.ifsp.agendamento.model.Cliente;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/agendamento")
@Slf4j
@SessionAttributes("cliente")
public class AgendamentoController {
	
	@Autowired
	private AgendamentoRepositorio agendamentoRepo;
	
	@ModelAttribute(name = "agendamento")
	public Agendamento agendamento() {
		return new Agendamento();
	}
	
	@ModelAttribute(name = "cliente")
	public Cliente cliente() {
		return new Cliente();
	}
	
	@GetMapping
	public String AgendamentoForm() {
		
		return "agendamento";
	}
	
	
	@PostMapping
	public String agendar(@Valid Agendamento agendamento, @ModelAttribute Cliente cliente, 
			Errors errors, SessionStatus sessionStatus) {
		
		if(errors.hasErrors()) {
			return "agendamento";
		}
		
		agendamento.setCliente(cliente);
		agendamento = agendamentoRepo.save(agendamento);
		sessionStatus.setComplete();
		log.info("Dados agendamento: " + agendamento);
		
		return "redirect:/cadastro";
	}
	
	

}
