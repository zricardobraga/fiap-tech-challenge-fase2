package br.com.restaurant_manager.restaurant_manager.infra.controller.dtos.request.restaurante;

import br.com.restaurant_manager.restaurant_manager.model.ENUM.HorarioDeFuncionamentoEnum;
import br.com.restaurant_manager.restaurant_manager.model.ENUM.TipoDeCozinhaEnum;
import br.com.restaurant_manager.restaurant_manager.model.Endereco;

public record RestauranteRequestDTO(String nome, Endereco endereco, TipoDeCozinhaEnum tipoDeCozinha, HorarioDeFuncionamentoEnum horarioDeFuncionamento, Long proprietarioId) {
}
