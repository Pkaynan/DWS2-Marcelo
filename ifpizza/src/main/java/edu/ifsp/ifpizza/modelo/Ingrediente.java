package ifsp.edu.IFPizza.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Ingrediente {
	private final String id;
	private final String nome;
	private final Tipo tipo;
	
	public Ingrediente(String id, String nome, Tipo tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
	}

	public enum Type {
			BORDA, PROTEINA, VEGETAIS, QUEIJO
		}

	public String getId() {
		return id;
	}

	public String getName() {
		return nome;
	}

	public Type getType() {
		return tipo;
	}
	
	
}
