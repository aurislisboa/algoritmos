package com.algoritmos.ex3;

public class Funcionario {
  
  private Cargo cargoFuncionario;
  private Character sexo;
  private Double qtdHorasTrabalhadas;

  public Double getSalarioFinal() {
      Double resultado = this.cargoFuncionario.getValorHora() * this.qtdHorasTrabalhadas; 
      if (sexo.equals('f')) {
        return resultado += resultado * 0.2;
      }
      return resultado;
  }


  public Funcionario() {
    super();
  }

  public Cargo getCargoFuncionario() {
    return this.cargoFuncionario;
  }

  public void setCargoFuncionario(Cargo cargoFuncionario) {
    this.cargoFuncionario = cargoFuncionario;
  }

  public Character getSexo() {
    return this.sexo;
  }

  public void setSexo(Character sexo) {
    this.sexo = sexo;
  }

  public Double getQtdHorasTrabalhadas() {
    return this.qtdHorasTrabalhadas;
  }

  public void setQtdHorasTrabalhadas(Double qtdHorasTrabalhadas) {
    this.qtdHorasTrabalhadas = qtdHorasTrabalhadas;
  }



  
 

}
