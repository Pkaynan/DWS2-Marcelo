package edu.ifsp.ifpizza.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ifsp.ifpizza.data.IngredienteRepositorio;
import edu.ifsp.ifpizza.model.Ingrediente;
import edu.ifsp.ifpizza.model.Ingrediente.Tipo;
import edu.ifsp.ifpizza.model.Pizza;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/design")
@Slf4j
public class MontarPizzaController {
	@Autowired
	private IngredienteRepositorio ingredienteRepo;

	@GetMapping
	public String showDesignForm(Model model) {
	    List<Ingrediente> ingredientes = new ArrayList<>();
	    ingredienteRepo.findAll().forEach(ingredientes::add);


	    for (Tipo tipo : Tipo.values()) {
	    	List<Ingrediente> filtrados = filtrarPorTipo(ingredientes, tipo);
	    	String categoria = tipo.toString().toLowerCase();
	    	model.addAttribute(categoria, filtrados);
	    }
	    
	    model.addAttribute("pizza", new Pizza());
		return "design";
	}
	

	private List<Ingrediente> filtrarPorTipo(List<Ingrediente> ingredientes, Tipo tipo) {
		return ingredientes.stream()
				.filter(ing -> ing.getTipo().equals(tipo))
				.collect(Collectors.toList());
	}
	
	@PostMapping
	public String processar(@Valid Pizza pizza, Errors errors) {
		if (errors.hasErrors()) {
			return "design";
		}
		
		log.info("Processando pizza: " + pizza);
		return "redirect:/pedidos/atual";
	}
}
