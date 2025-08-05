package br.com.restaurant_manager.restaurant_manager.infra.controller.dtos.request.item;

public record ItemRequestDTO(String nome, String descricao, Double preco, boolean disponibilidadeDePedirApenasNoRestaurante, String fotoDoPrato) {}
