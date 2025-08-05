package br.com.restaurant_manager.restaurant_manager.application.usecases.restaurante;

import br.com.restaurant_manager.restaurant_manager.application.gateways.restaurante.RepositorioDeRestaurante;
import br.com.restaurant_manager.restaurant_manager.model.entities.restaurante.Restaurante;

public class CadastrarRestaurante {

    private final RepositorioDeRestaurante repositorioDeRestaurante;

    public CadastrarRestaurante(RepositorioDeRestaurante repositorioDeRestaurante) {
        this.repositorioDeRestaurante = repositorioDeRestaurante;
    }

    public Restaurante cadastrarRestaurante(Restaurante restaurante) { return this.repositorioDeRestaurante.cadastrar(restaurante); }
}
