package br.com.restaurant_manager.restaurant_manager.application.usecases.item;

import br.com.restaurant_manager.restaurant_manager.application.gateways.item.RepositorioDeItem;

public class RemoverItem {

    private final RepositorioDeItem repositorioDeItem;

    public RemoverItem(RepositorioDeItem repositorioDeItem) {
        this.repositorioDeItem = repositorioDeItem;
    }

    public void removerItem(Long id){ this.repositorioDeItem.remover(id);}
}
