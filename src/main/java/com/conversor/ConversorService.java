package com.conversor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConversorService {
  public static Moeda lerJson(HttpResponse<String> response) throws IOException, InterruptedException {
   System.out.println("Resposta da API (JSON): " + response.body());
    
    Gson gson = new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        .setPrettyPrinting()
        .create();

    Moeda moedas = gson.fromJson(response.body(), Moeda.class);
    return moedas;
  }

  public static Moeda fazerRequisicao(String apiKey, String moeda_1, String moeda_2)
      throws IOException, InterruptedException {
    String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + moeda_1 + "/" + moeda_2;
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
