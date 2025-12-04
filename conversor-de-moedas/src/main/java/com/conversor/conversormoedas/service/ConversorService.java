package com.conversor.conversormoedas.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.conversor.conversormoedas.dto.ConversaoResponse;
import com.conversor.conversormoedas.exception.MoedaNaoEncontradaException;
import com.conversor.conversormoedas.model.Moeda;
import com.conversor.conversormoedas.model.MoedasSuportadas;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class ConversorService {

  @Value("${exchangerate.api.key}")
  private String apiKey;

  private final HttpClient httpClient;
  private final Gson gson;

  public ConversorService() {
    this.httpClient = HttpClient.newHttpClient();
    this.gson = new GsonBuilder().setPrettyPrinting().create();
  }

  public Moeda buscarTaxaConversao(String moedaOrigem, String moedaDestino)
      throws IOException, InterruptedException, MoedaNaoEncontradaException {

    String url = String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s",
        apiKey, moedaOrigem, moedaDestino);
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .GET()
        .build();

    HttpResponse<String> response = httpClient.send(request,
        HttpResponse.BodyHandlers.ofString());

    return processarResposta(response);

  }

  public ConversaoResponse converter(String moedaOrigem, String moedaDestino, Double valor)
      throws IOException, InterruptedException, MoedaNaoEncontradaException {

    Moeda moeda = buscarTaxaConversao(moedaOrigem, moedaDestino);
    double valorConvertido = valor * moeda.taxaConversao();

    return new ConversaoResponse(
        moeda.moedaOrigem(),
        moeda.moedaDestino(),
        moeda.taxaConversao(),
        valor,
        valorConvertido);
  }

  public MoedasSuportadas buscarMoedasSuportadas()
      throws IOException, InterruptedException {

    String url = String.format(
        "https://v6.exchangerate-api.com/v6/%s/codes",
        apiKey);

    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .GET()
        .build();

    HttpResponse<String> response = httpClient.send(request,
        HttpResponse.BodyHandlers.ofString());

    return gson.fromJson(response.body(), MoedasSuportadas.class);
  }

  private Moeda processarResposta(HttpResponse<String> response)
      throws MoedaNaoEncontradaException {

    JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();

    if (jsonObject.has("error-type")) {
      String errorType = jsonObject.get("error-type").getAsString();
      throw new MoedaNaoEncontradaException(
          "Erro ao buscar moeda: " + errorType);
    }

    return gson.fromJson(response.body(), Moeda.class);
  }
}
