package com.conversor;

import io.github.cdimascio.dotenv.Dotenv;

public class App {
  public static void main(String[] args) {
    Dotenv dotenv = Dotenv.load();

    String apiKey = dotenv.get("API_KEY");

    if (apiKey != null) {
      System.out.println("API Key carregada com sucesso");
      try {
        String resultado = ConversorService.fazerRequisicao("EUR", apiKey);
        System.out.println("Resultado da requisição: " + resultado);
      } catch (Exception e) {
        System.out.println("Erro: " + e.getStackTrace());
      }
    } else {
      System.out.println("Erro: API Key não encontrada nas variáveis de ambiente.");
    }
  }
}
