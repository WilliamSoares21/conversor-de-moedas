package com.conversor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConversorService {
  public static Moeda lerJson(HttpResponse<String> response)
      throws IOException, InterruptedException, MoedaNaoEncontradaException {
    /* System.out.println("Resposta da API (JSON): " + response.body()); */

    Gson gson = new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        .setPrettyPrinting()
        .create();
    JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
    if (jsonObject.has("result") && !"success".equals(jsonObject.get("result").getAsString())) {
      throw new MoedaNaoEncontradaException("Moeda não encontrada ou inválida.");
    }
    Moeda moedas = gson.fromJson(response.body(), Moeda.class);
    return moedas;
  }

  public static Moeda fazerRequisicao(String apiKey, String moeda_1, String moeda_2)
      throws IOException, InterruptedException, MoedaNaoEncontradaException {
    String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + moeda_1 + "/" + moeda_2;
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .GET()
        .build();

    HttpResponse<String> response;
    if (moeda_1.isEmpty() || moeda_2.isEmpty()) {
      throw new MoedaNaoEncontradaException("Moeda de origem ou destino não pode ser vazia.");
    } else if (moeda_1.length() != 3 || moeda_2.length() != 3) {
      throw new MoedaNaoEncontradaException("Código da moeda deve ter exatamente 3 caracteres.");
    } else if (!moeda_1.matches("[A-Z]{3}") || !moeda_2.matches("[A-Z]{3}")) {
      throw new MoedaNaoEncontradaException("Código da moeda deve conter apenas letras maiúsculas (A-Z).");
    } else if (moeda_1.equals(moeda_2) || moeda_2.equalsIgnoreCase(moeda_1)) {
      throw new MoedaNaoEncontradaException("Moeda de origem e destino não podem ser iguais.");
    }

    try {
      response = client.send(request, HttpResponse.BodyHandlers.ofString());
    } catch (Exception e) {
      System.out.println("Erro ao fazer a requisição: " + e.getMessage());
      return null;
    }
    return lerJson(response);
  }

}
