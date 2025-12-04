package com.conversor.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conversor.dto.ConversaoRequest;
import com.conversor.dto.ConversaoResponse;
import com.conversor.exception.MoedaNaoEncontradaException;
import com.conversor.model.Moeda;
import com.conversor.model.MoedasSuportadas;
import com.conversor.service.ConversorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/conversor")
@Validated
public class ConversorController {

  private final ConversorService conversorService;

  public ConversorController(ConversorService conversorService) {
    this.conversorService = conversorService;
  }

  @GetMapping("/moedas")
  public ResponseEntity<MoedasSuportadas> listarMoedas() {
    try {
      MoedasSuportadas moedas = conversorService.buscarMoedasSuportadas();
      return ResponseEntity.ok(moedas);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GetMapping("/taxa")
  public ResponseEntity<Moeda> buscarTaxa(
      @RequestParam String origem,
      @RequestParam String destino) {
    try {
      Moeda moeda = conversorService.buscarTaxaConversao(origem.toUpperCase(), destino.toUpperCase());
      return ResponseEntity.ok(moeda);
    } catch (MoedaNaoEncontradaException e) {
      return ResponseEntity.notFound().build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @PostMapping("/converter")
  public ResponseEntity<ConversaoResponse> converter(@Valid @RequestBody ConversaoRequest request) {
    try {

      ConversaoResponse resultado = conversorService.converter(
          request.moedaOrigem().toUpperCase(),
          request.moedaDestino().toUpperCase(),
          request.valor());
      return ResponseEntity.ok(resultado);
    } catch (MoedaNaoEncontradaException e) {
      return ResponseEntity.notFound().build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}
