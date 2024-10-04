package edu.ifsp.ifpizza.modelo;

public class Ingrediente {
	private final String id;
	private final String nome;
	private final Tipo tipo;
	
	public enum Tipo{
		BORDA, PROTEINA, VEGETAIS, QUEIJO
	}
}
