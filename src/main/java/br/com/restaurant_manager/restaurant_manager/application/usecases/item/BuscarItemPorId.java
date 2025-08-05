package br.com.restaurant_manager.restaurant_manager.application.usecases.item;

import br.com.restaurant_manager.restaurant_manager.application.gateways.item.RepositorioDeItem;
import br.com.restaurant_manager.restaurant_manager.model.entities.item.Item;

public class BuscarItemPorId {

    private final RepositorioDeItem repositorioDeItem;

    public BuscarItemPorId(RepositorioDeItem repositorioDeItem) {
        this.repositorioDeItem = repositorioDeItem;
    }

    public Item buscarItemPorId(Long id){ return this.repositorioDeItem.buscarPorId(id); }
}
