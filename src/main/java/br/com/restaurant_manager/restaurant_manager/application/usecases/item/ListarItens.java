package br.com.restaurant_manager.restaurant_manager.application.usecases.item;

import br.com.restaurant_manager.restaurant_manager.application.gateways.item.RepositorioDeItem;
import br.com.restaurant_manager.restaurant_manager.model.entities.item.Item;

import java.util.List;

public class ListarItens {

    private final RepositorioDeItem repositorioDeItem;

    public ListarItens(RepositorioDeItem repositorioDeItem) {
        this.repositorioDeItem = repositorioDeItem;
    }

    public List<Item> listarTodosOsItens(){ return this.repositorioDeItem.listar(); }
}
