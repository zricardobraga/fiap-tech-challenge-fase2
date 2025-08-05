package br.com.restaurant_manager.restaurant_manager.application.usecases.restaurante;

import br.com.restaurant_manager.restaurant_manager.application.gateways.restaurante.RepositorioDeRestaurante;
import br.com.restaurant_manager.restaurant_manager.model.entities.restaurante.Restaurante;

import java.util.List;

public class ListarRestaurantes {

    private final RepositorioDeRestaurante repositorioDeRestaurante;

    public ListarRestaurantes(RepositorioDeRestaurante repositorioDeRestaurante) {
        this.repositorioDeRestaurante = repositorioDeRestaurante;
    }

    public List<Restaurante> listarTodosOsRestaurantes() { return this.repositorioDeRestaurante.listar(); }
}
