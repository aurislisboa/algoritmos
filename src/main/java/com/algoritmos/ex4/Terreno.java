package com.algoritmos.ex4;

public class Terreno extends Imovel {


  public Terreno() {
  }

  public Terreno(String proprietario, Integer quadra, Integer lote, Double area, Double valorVenda) {
      super(proprietario, quadra, lote, area, valorVenda);
  }

  

 @Override
 public void calcularIptu() {
   super.setValorIptu(super.getValorVenda() * 0.02);
 }


  


}
