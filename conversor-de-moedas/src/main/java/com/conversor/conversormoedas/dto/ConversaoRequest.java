package com.conversor.conversormoedas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ConversaoRequest(
    @NotBlank(message = "Moeda de origem é obrigatória") String moedaOrigem,

    @NotBlank(message = "Moeda de destino é obrigatória") String moedaDestino,

    @Positive(message = "Valor deve ser positivo") Double valor) {
}
