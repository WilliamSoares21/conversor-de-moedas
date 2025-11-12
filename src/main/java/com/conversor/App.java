package com.conversor;

import io.github.cdimascio.dotenv.Dotenv;

public class App {
  public static void main(String[] args) {
    Dotenv dotenv = Dotenv.load();

    String apiKey = dotenv.get("API_KEY");
    String moeda_1 = "BRL";
    String moeda_2 = "EUR";

    if (apiKey != null) {
      System.out.println("API Key carregada com sucesso");
      try {
        Moeda resultadoConversao = ConversorService.fazerRequisicao(apiKey, moeda_1, moeda_2);
        System.out.println("Resultado da requisição: " + resultadoConversao);
      } catch (Exception e) {
        System.out.println("Erro: " + e.getStackTrace());
      }
    } else {
      System.out.println("Erro: API Key não encontrada nas variáveis de ambiente.");
    }
  }
}
