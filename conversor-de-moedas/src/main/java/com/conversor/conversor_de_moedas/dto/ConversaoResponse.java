package com.conversor.dto;

public record ConversaoResponse(
    String moedaOrigem,
    String moedaDestino,
    Double taxaConversao,
    Double valorOriginal,
    Double valorConvertido) {
}
