package com.conversor;

import com.google.gson.annotations.SerializedName;

public record Moeda(
    @SerializedName("base_code") String moedaOrigem,
    @SerializedName("target_code") String moedaDestino,
    @SerializedName("conversion_rate") double taxaConversao) {

    @Override
    public String toString() {
        return String.format(
            "\n=== RESULTADO DA CONVERSÃO ===\n" +
            "Moeda de Origem:  %s\n" +
            "Moeda de Destino: %s\n" +
            "Taxa de Conversão: %.2f\n" +
            "=============================",
            moedaOrigem, 
            moedaDestino, 
            taxaConversao
        );
    }
}
