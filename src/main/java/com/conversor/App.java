package com.conversor;

import java.io.IOException;
import java.util.Scanner;

import io.github.cdimascio.dotenv.Dotenv;

public class App {
  public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    Dotenv dotenv = Dotenv.load();

    String apiKey = dotenv.get("API_KEY");
    String moedaDeOrigem;
    String moedaDeDestino;
    System.out.println("Seja bem vindo ao conversor de Moedas!");
    System.out.println("Nossas moedas disponíveis são: EUR, USD, GBP, ARS, JPY, KRW e muitas outras!");

    while (true) {
      System.out.println("O que deseja fazer ?");
      System.out.println("1 - Converter moedas");
      System.out.println("2 - Consultar moedas disponíveis");
      System.out.println("0 - Sair");
      String opcao = scan.nextLine();
      switch (opcao) {
        case "1":
          if (apiKey != null) {
            /* System.out.println("API Key carregada com sucesso"); */
            System.out.println("\n--- CONVERSÃO DE MOEDAS ---");
            System.out.println("Insira a moeda de origem (ex: USD, EUR):");
            moedaDeOrigem = scan.nextLine().toUpperCase();
            System.out.println("Insira a moeda de destino (ex: USD, EUR):");
            moedaDeDestino = scan.nextLine().toUpperCase();
            try {
              Moeda resultadoConversao = ConversorService.fazerRequisicao(apiKey, moedaDeOrigem, moedaDeDestino);
              System.out.println("Resultado da requisição: " + resultadoConversao);
            } catch (MoedaNaoEncontradaException e) {
              System.out.println("Erro: " + e.getMessage());

            } catch (Exception e) {
              System.out.println("Erro: " + e.getStackTrace());
            }
          } else {
            System.out.println("Erro: API Key não encontrada nas variáveis de ambiente.");
          }
          break;
        case "2":
          System.out.println("\n--- CONSULTA DE MOEDAS ---");
          System.out.println("Escolha a região para filtrar:");

          String[] regioes = TabelaMoedas.getOpcoesRegiao();
          for (int i = 0; i < regioes.length; i++) {
            System.out.printf("%d - %s%n", i + 1, regioes[i].replace('_', ' '));
          }
          System.out.println("0 - Voltar ao menu principal");

          String escolhaRegiao = scan.nextLine();

          if (escolhaRegiao.equals("0")) {
            break; // Volta ao menu principal
          }

          try {
            int indice = Integer.parseInt(escolhaRegiao) - 1;
            if (indice >= 0 && indice < regioes.length) {
              String filtro = regioes[indice];
              // CHAMADA COM FILTRO!
              TabelaMoedas.exibirMoedas(TabelaMoedas.getDadosMoedas(), filtro);
            } else {
              System.out.println("Opção inválida.");
            }
          } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Digite o número da opção.");
          }
          break;
        case "0":
          System.out.println("Obrigado por usar o conversor de moedas. Até mais!");
          scan.close();
          return;
        default:
          System.out.println("Opção inválida. Tente novamente.");
      }
    }
  }
}
