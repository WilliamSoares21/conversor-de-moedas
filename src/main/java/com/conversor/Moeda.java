package com.conversor;

import com.google.gson.annotations.SerializedName;

public record Moeda(
    @SerializedName("base_code") String moedaOrigem,
    @SerializedName("target_code") String moedaDestino,
    @SerializedName("conversion_rate") double taxaConversao) {
}
