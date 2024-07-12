package com.algoritmos.ex1;

public class Produto {
  
  private String descricao;
  private Tipo tipo;
  private Double preco;
  private Double imposto;


  public Double calcular() {
    return this.preco + this.imposto;
  }




}
