package br.com.restaurant_manager.restaurant_manager.application.usecases.restaurante;

import br.com.restaurant_manager.restaurant_manager.application.gateways.restaurante.RepositorioDeRestaurante;
import br.com.restaurant_manager.restaurant_manager.model.entities.restaurante.Restaurante;

public class AtualizarRestaurante {

    private final RepositorioDeRestaurante repositorioDeRestaurante;

    public AtualizarRestaurante(RepositorioDeRestaurante repositorioDeRestaurante) {
        this.repositorioDeRestaurante = repositorioDeRestaurante;
    }

    public Restaurante atualizarRestaurante(Long id, Restaurante restaurante) { return this.repositorioDeRestaurante.atualizar(id, restaurante); }
}
