package edu.ifsp.ifpizza.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity
public class Ingrediente {

  @Id
  @Column(columnDefinition = "CHAR(4)")
  private final String id;
  private final String nome;
  
  @Enumerated(EnumType.STRING)  
  private final Tipo tipo;

  public static enum Tipo {
    BORDA, PROTEINA, VEGETAIS, QUEIJO
  }

}
