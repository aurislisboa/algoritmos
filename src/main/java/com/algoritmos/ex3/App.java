package com.algoritmos.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
   
    Scanner sc = new Scanner(System.in);
    // Cargo cargos[] = new Cargo[3]; 
    List<Cargo> cargos = new ArrayList<>();
    Funcionario funcionario = new Funcionario();

    // cargos[0] = new Cargo(1, 15.0);
    // cargos[1] = new Cargo(2, 20.0);
    // cargos[2] = new Cargo(3, 32.0);
    cargos.add(new Cargo(1, 15.0));
    cargos.add(new Cargo(2, 20.0));
    cargos.add(new Cargo(3, 32.0));
    
    System.out.print("\n\nDigite o sexo: ");    
    funcionario.setSexo(sc.next().toLowerCase().charAt(0));
    System.out.print("Qtd horas trabalhadas: ");
    funcionario.setQtdHorasTrabalhadas(sc.nextDouble());
    System.out.print("Cargo: 1, 2, 3: ");
    int opcao = sc.nextInt();
    funcionario.setCargoFuncionario(cargos.get(opcao));

    System.out.println("Cargo: " + funcionario.getCargoFuncionario().getNumero());
    System.out.printf("Salário Final: %.2f", funcionario.getSalarioFinal());
    
    sc.close();


  }
}
