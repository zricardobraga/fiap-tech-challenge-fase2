package br.com.restaurant_manager.restaurant_manager.infra.controller.dtos.response.item;

public record ItemResponseDTO(Long id, String nome, String descricao, Double preco, boolean disponibilidadeDePedirApenasNoRestaurante, String fotoDoPrato) {}
