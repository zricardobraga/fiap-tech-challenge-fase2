package br.com.restaurant_manager.restaurant_manager.application.usecases.item;

import br.com.restaurant_manager.restaurant_manager.application.gateways.item.RepositorioDeItem;
import br.com.restaurant_manager.restaurant_manager.model.entities.item.Item;

public class CadastrarItem {

    private final RepositorioDeItem repositorioDeItem;

    public CadastrarItem(RepositorioDeItem repositorioDeItem) {
        this.repositorioDeItem = repositorioDeItem;
    }

    public Item cadastrarItem(Item item){
        return this.repositorioDeItem.cadastrar(item);
    }
}
