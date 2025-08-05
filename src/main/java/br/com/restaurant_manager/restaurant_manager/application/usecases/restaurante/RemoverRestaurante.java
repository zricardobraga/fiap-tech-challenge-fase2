package br.com.restaurant_manager.restaurant_manager.application.usecases.restaurante;

import br.com.restaurant_manager.restaurant_manager.application.gateways.restaurante.RepositorioDeRestaurante;

public class RemoverRestaurante {

    private final RepositorioDeRestaurante repositorioDeRestaurante;

    public RemoverRestaurante(RepositorioDeRestaurante repositorioDeRestaurante) {
        this.repositorioDeRestaurante = repositorioDeRestaurante;
    }

    public void removerRestaurante(Long id) { this.repositorioDeRestaurante.remover(id); }
}
