package com.algoritmos.ex4;

public abstract class Imovel {
  
  private String proprietario;
  private Integer quadra;
  private Integer lote;
  private Double area;
  private Double valorVenda;
  private Situacao situacao;
  private Double valorComissao;
  private double valorIptu;






  public Imovel() {
    super();
    this.situacao = Situacao.A_VENDA;
    valorComissao = 0.0;
  }




  public Imovel(String proprietario, Integer quadra, Integer lote, Double area, Double valorVenda) {
    this.proprietario = proprietario;
    this.quadra = quadra;
    this.lote = lote;
    this.area = area;
    this.situacao = Situacao.A_VENDA;
    this.valorVenda = valorVenda;
    this.valorComissao = 0.0;
  }


  // método a implementar
  public abstract void calcularIptu();


  public String getProprietario() {
    return this.proprietario;
  }

  public void setProprietario(String proprietario) {
    this.proprietario = proprietario;
  }

  public Integer getQuadra() {
    return this.quadra;
  }

  public void setQuadra(Integer quadra) {
    this.quadra = quadra;
  }

  public Integer getLote() {
    return this.lote;
  }

  public void setLote(Integer lote) {
    this.lote = lote;
  }

  public Double getArea() {
    return this.area;
  }

  public void setArea(Double area) {
    this.area = area;
  }

  public Double getValorVenda() {
    return this.valorVenda;
  }

  public void setValorVenda(Double valorVenda) {
    this.valorVenda = valorVenda;
  }

  public Situacao getSituacao() {
    return this.situacao;
  }

  public void setSituacao(Situacao situacao) {
    this.situacao = situacao;
  }



  public Double getValorComissao() {
    if (getSituacao() == Situacao.VENDIDO) {
      return this.valorComissao;
    }
    return 0.0;
  }



  public void setValorComissao(Double valorComissao) {
     if (valorComissao > 10) 
        throw new IllegalArgumentException("Comissão superior a 10%");
    this.valorComissao = this.valorVenda * (valorComissao / 100);
  }



  public double getValorIptu() {
    return this.valorIptu;
  }

  protected void setValorIptu(double valorIptu) {
    this.valorIptu = valorIptu;
  }


  

  @Override
  public String toString() {
    return 
      "\n proprietario='" + getProprietario() + "'" +
      "\n quadra='" + getQuadra() + "'" +
      "\n lote='" + getLote() + "'" +
      "\n area='" + getArea() + "'" +
      "\n valorVenda='" + getValorVenda() + "'" +
      "\n situacao='" + getSituacao() + "'" +
      "\n valorComissao='" + getValorComissao() + "'" +
      "\n valorIptu='" + getValorIptu() + "'";
  }
  

}
