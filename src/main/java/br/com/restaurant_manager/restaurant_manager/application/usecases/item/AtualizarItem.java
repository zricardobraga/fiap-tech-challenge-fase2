package br.com.restaurant_manager.restaurant_manager.application.usecases.item;

import br.com.restaurant_manager.restaurant_manager.application.gateways.item.RepositorioDeItem;
import br.com.restaurant_manager.restaurant_manager.model.entities.item.Item;

public class AtualizarItem {

    private final RepositorioDeItem repositorioDeItem;

    public AtualizarItem(RepositorioDeItem repositorioDeItem) {
        this.repositorioDeItem = repositorioDeItem;
    }

    public Item atualizarItem(Long id, Item item){ return this.repositorioDeItem.atualizar(id, item); }
}
