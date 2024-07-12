package com.algoritmos.ex4;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class App {
  
  public static int contador = 0;
  public static List<Imovel> imoveis = new ArrayList<>();

  public static void main(String[] args) {
  

    pupulaValores();


    int opcao, tipo = 0;
    do {
      opcao = menu();

      switch (opcao) {
        case 1:
            tipo = Integer.parseInt(JOptionPane.showInputDialog("Escolha o tipo de imóvel: \n 1-Casa; 2-Terreno"));
            if (tipo == 1) {
                Casa casa = geraNovaCasa();
                cadastraNovoImovel(casa);
            } else if(tipo == 2) {
                Terreno terreno = geraNovoTerreno();
                cadastraNovoImovel(terreno);
            } else {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
          break;

        case 2:
            alterarSituacaoImovel(imoveis);
          break;

        case 3:
            String totalValor = String.format("O somatório do valor de venda dos imóveis é: %.2f", gerarValorTotalDosImoveis());
            JOptionPane.showMessageDialog(null, totalValor);
        break;
      
        case 4:
          String totalComissao = String.format("O  somatório  do  valor  das  comissões  dos imóveis vendidos é: %.2f", gerarValorTotalComissaoImoveis());  
          JOptionPane.showMessageDialog(null, totalComissao);
        break;

        case 5:
          JOptionPane.showMessageDialog(null, "Fim da execução do programa.");
        break;

        default: JOptionPane.showMessageDialog(null, "Opção inválida! \nEscolha entre 1 e 5");
          break;
      }

    } while(opcao != 5); 
  
  } //End-App





  
  public static int menu() {
      StringBuffer msg = new StringBuffer();
      msg.append("1- Cadastrar Imóvel \n");
      msg.append("2- Alterar situacao de um imóvel\n");
      msg.append("3- Somatório do valor dos imóveis\n");
      msg.append("4- Somatório do valor das comissões\n");
      msg.append("5- Finalizar execucao\n");
      msg.append("\nDigite a opção desejada: ");
    return Integer.parseInt(JOptionPane.showInputDialog(msg));
  }


  
  public static Casa geraNovaCasa() {
      Casa novaCasa = new Casa();
      novaCasa.setProprietario(JOptionPane.showInputDialog("Digite o nome do proprietário: "));
      novaCasa.setQuadra(Integer.parseInt(JOptionPane.showInputDialog("Digite a quadra: ")));
      novaCasa.setLote(Integer.parseInt(JOptionPane.showInputDialog("Digite o lote: ")));
      novaCasa.setArea(Double.parseDouble(JOptionPane.showInputDialog("Digite a área: ")));
      novaCasa.setValorVenda(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de venda: ")));
      novaCasa.setAreaConstruida(Double.parseDouble(JOptionPane.showInputDialog("Digite a área construída: ")));
    return novaCasa;
  }


  public static Terreno geraNovoTerreno() {
      Terreno novoTerreno = new Terreno();
      novoTerreno.setProprietario(JOptionPane.showInputDialog("Digite o nome do proprietário: "));
      novoTerreno.setQuadra(Integer.parseInt(JOptionPane.showInputDialog("Digite a quadra: ")));
      novoTerreno.setLote(Integer.parseInt(JOptionPane.showInputDialog("Digite o lote: ")));
      novoTerreno.setArea(Double.parseDouble(JOptionPane.showInputDialog("Digite a área: ")));
      novoTerreno.setValorVenda(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de venda: ")));
    return novoTerreno;
  }
  


  public static void cadastraNovoImovel(Imovel imovel) {
      if (contador < 10) {
          imoveis.add(imovel);
          contador++;
      } else { 
          JOptionPane.showMessageDialog(null, "Total de 10 imóveis foi excedido!");
      }
  }



  
  public static void alterarSituacaoImovel(List<Imovel> imoveis) {
      Situacao novaSituacao;
      int indice = Integer.parseInt(JOptionPane.showInputDialog("Digite o índice do imóvel desejado: "));

      if (indice >= 0 && indice < imoveis.size()) {

        try {
                  novaSituacao = Situacao.valueOf(JOptionPane.showInputDialog("A situação atual do imóvel é: " + imoveis.get(indice).getSituacao() + 
                       "\n Digite a nova situaçao: (a_venda, vendido ou em_negociacao)").toUpperCase());
              
                  while (novaSituacao.equals(imoveis.get(indice).getSituacao())) {
                        novaSituacao = Situacao.valueOf(JOptionPane.showInputDialog("ERRO! A situação atual do imóvel é: " + imoveis.get(indice).getSituacao() + 
                        "\n Digite a nova situaçao: (a_venda, vendido ou em_negociacao)").toUpperCase());
                  }

                  if (novaSituacao.equals(Situacao.VENDIDO)) {
                      Double comissao = Double.valueOf(JOptionPane.showInputDialog("Digite o % da comissão: "));
                      imoveis.get(indice).setValorComissao(comissao);
                  } else {
                      imoveis.get(indice).setValorComissao(0.0);
                  }

                  imoveis.get(indice).setSituacao(novaSituacao);

            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Situação Inválida!");
            }

      } else {
          JOptionPane.showMessageDialog(null, "Índice inválido!");
      }
  }


  

  public static Double gerarValorTotalDosImoveis() {
    Double total = 0.0;
      for (Imovel imovel : imoveis) {
          total += imovel.getValorVenda();
      }
    return total;
  }

  
  public static Double gerarValorTotalComissaoImoveis() {
    Double total = 0.0;
      for(Imovel imovel : imoveis) {
          total += imovel.getValorComissao();
      }
    return total;
  }




  public static void pupulaValores() {
      imoveis.add(new Casa("Maria", 8, 8, 80.0, 80000.00, 80.0));
      imoveis.add(new Casa("José", 9, 9, 90.0, 90000.00, 90.0));
      imoveis.add(new Terreno("Pedro", 10, 10, 10000.00, 90000.00));
      imoveis.add(new Terreno("Marcos", 11, 11, 11000.90, 110000.00));
  }
 
  


}//End-Class