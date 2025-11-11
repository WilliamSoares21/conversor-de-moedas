package com.conversor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorService {
  public static String lerJson(HttpResponse<String> response) throws IOException, InterruptedException {
    String responseBody = response.body();
    System.out.println("Resposta da API: ");
    return responseBody;
  }

  public static String fazerRequisicao(String moeda, String apiKey) throws IOException, InterruptedException {
    String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .GET()
        .build();

    HttpResponse<String> response;
    try {
      response = client.send(request, HttpResponse.BodyHandlers.ofString());
    } catch (Exception e) {
      System.out.println("Erro ao fazer a requisição: " + e.getMessage());
      return null;
    }
    return lerJson(response);
  }

}
