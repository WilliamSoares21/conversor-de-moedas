package com.conversor.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public record MoedasSuportadas(
    String result,
    @SerializedName("supported_codes") List<List<String>> supportedCodes) {
  /**
   * Retorna uma lista apenas com os códigos das moedas (sem os nomes)
   */
  public List<String> getCodigosMoedas() {
    return supportedCodes.stream()
        .map(par -> par.get(0)) // Pega o primeiro elemento (código)
        .toList();
  }

  /**
   * Verifica se uma moeda é suportada
   */
  public boolean ehMoedaValida(String codigo) {
    return getCodigosMoedas().contains(codigo.toUpperCase());
  }

  /**
   * Busca o nome de uma moeda pelo código
   */
  public String getNomeMoeda(String codigo) {
    return supportedCodes.stream()
        .filter(par -> par.get(0).equalsIgnoreCase(codigo))
        .map(par -> par.get(1))
        .findFirst()
        .orElse("Moeda não encontrada");
  }
}
