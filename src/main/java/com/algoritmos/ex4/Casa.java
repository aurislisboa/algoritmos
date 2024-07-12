package com.algoritmos.ex4;

public class Casa extends Imovel {

  private Double areaConstruida;


  public Casa() {
    super();
  }


  public Casa(String proprietario, Integer quadra, Integer lote, Double area, Double valorVenda, Double areaConstruida) {
      super(proprietario, quadra, lote, area, valorVenda);
      this.areaConstruida = areaConstruida;
  }



  public Double getAreaConstruida() {
    return this.areaConstruida;
  }

  public void setAreaConstruida(Double areaConstruida) {
    this.areaConstruida = areaConstruida;
  }


  
  @Override
  public void calcularIptu() {
      super.setValorIptu(super.getValorVenda() * 0.01);    
  }

  
}
