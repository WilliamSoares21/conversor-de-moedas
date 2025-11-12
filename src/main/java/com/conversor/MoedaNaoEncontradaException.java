package com.conversor;

public class MoedaNaoEncontradaException extends Exception {
  public MoedaNaoEncontradaException(String mensagem) {
    super(mensagem);
  }
}
