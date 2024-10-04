package edu.ifsp.ifpizza.web;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import edu.ifsp.ifpizza.modelo.Ingrediente;
import edu.ifsp.ifpizza.modelo.Ingrediente.Tipo;
import edu.ifsp.ifpizza.modelo.Pizza;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/design")
public class montarPizzaController {
	
	@GetMapping
	public String showDesignForm(Model model) {
		List<Ingrediente> ingredientes = Arrays.asList(
				new Ingrediente("CTPY","Catupiry", Tipo.BORDA),
				new Ingrediente("SMPL","Simples", Tipo.BORDA),
				new Ingrediente("PRST","Presunto", Tipo.PROTEINA),
				new Ingrediente("CARN","Carne", Tipo.PROTEINA),
				new Ingrediente("TMTE","Tomate", Tipo.VEGETAIS),
				new Ingrediente("RCLA","Rúcula", Tipo.VEGETAIS),
				new Ingrediente("MSRL","Musssarela", Tipo.QUEIJO),
				new Ingrediente("PROV","Provolone", Tipo.QUEIJO)
				);
		
		for (Tipo tipo : Tipo.values()) {
			List<Ingrediente> filtrados = filtrarPortipo(ingredientes, tipo);
			model.addAttribute(tipo.toString().toLowerCase(), filtrados);
		}
		model.addAttribute("pizza", new Pizza());
		
		return "design";
	}
	
	private List<Ingrediente> filtrarPortipo(List<Ingrediente> ingredientes, Tipo tipo){
		return ingredientes.stream().filter(i -> i.getTipo().equals(tipo)).collect(Collectors.toList());
		
	}
	

}
