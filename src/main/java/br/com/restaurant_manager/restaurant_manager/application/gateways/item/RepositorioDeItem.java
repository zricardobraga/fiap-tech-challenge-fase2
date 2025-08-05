package br.com.restaurant_manager.restaurant_manager.application.gateways.item;

import br.com.restaurant_manager.restaurant_manager.model.entities.item.Item;

import java.util.List;

public interface RepositorioDeItem {
    Item cadastrar(Item item);
    List<Item> listar();
    Item buscarPorId(Long id);
    Item atualizar(Long id, Item item);
    void remover(Long id);
}
