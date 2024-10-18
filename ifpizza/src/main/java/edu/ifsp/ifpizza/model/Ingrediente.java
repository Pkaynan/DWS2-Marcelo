package edu.ifsp.ifpizza.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Ingrediente {

  private final String id;
  private final String nome;
  private final Tipo tipo;

  public enum Tipo {
    BORDA, PROTEINA, VEGETAIS, QUEIJO
  }

}