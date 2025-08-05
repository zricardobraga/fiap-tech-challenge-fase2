package br.com.restaurant_manager.restaurant_manager.application.gateways.restaurante;

import br.com.restaurant_manager.restaurant_manager.model.entities.restaurante.Restaurante;

import java.util.List;

public interface RepositorioDeRestaurante {
    Restaurante cadastrar(Restaurante restaurante);
    List<Restaurante> listar();
    Restaurante buscarPorId(Long id);
    Restaurante atualizar(Long id, Restaurante restaurante);
    void remover(Long id);
}
