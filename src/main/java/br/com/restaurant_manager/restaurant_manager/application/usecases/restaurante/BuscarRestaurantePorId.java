package br.com.restaurant_manager.restaurant_manager.application.usecases.restaurante;

import br.com.restaurant_manager.restaurant_manager.application.gateways.restaurante.RepositorioDeRestaurante;
import br.com.restaurant_manager.restaurant_manager.model.entities.restaurante.Restaurante;

public class BuscarRestaurantePorId {

    private final RepositorioDeRestaurante repositorioDeRestaurante;

    public BuscarRestaurantePorId(RepositorioDeRestaurante repositorioDeRestaurante) {
        this.repositorioDeRestaurante = repositorioDeRestaurante;
    }

    public Restaurante buscarRestaurantePorId(Long id) { return this.repositorioDeRestaurante.buscarPorId(id); }
}
