package br.com.restaurant_manager.restaurant_manager.infra.controller.dtos.request.usuario;

import br.com.restaurant_manager.restaurant_manager.model.Endereco;

public record UsuarioRequestDTO(String nome, String email, String login, String senha, Endereco endereco, Long tipoUsuarioId) {
}
