package com.conversor.conversormoedas.dto;

public record ConversaoResponse(
    String moedaOrigem,
    String moedaDestino,
    Double taxaConversao,
    Double valorOriginal,
    Double valorConvertido) {
}
