package br.com.restaurant_manager.restaurant_manager.infra.gateways.Item;

import br.com.restaurant_manager.restaurant_manager.infra.persistance.item.entity.ItemEntity;
import br.com.restaurant_manager.restaurant_manager.model.entities.item.Item;

public class ItemEntityMapper {

    public ItemEntity toEntity(Item item) {
        return new ItemEntity(
                item.getId(),
                item.getNome(),
                item.getDescricao(),
                item.getPreco(),
                item.isDisponibilidadeDePedirApenasNoRestaurante(),
                item.getFotoDoPrato());
    }

    public Item toDomain(ItemEntity itemEntity) {
        return new Item(
                itemEntity.getId(),
                itemEntity.getNome(),
                itemEntity.getDescricao(),
                itemEntity.getPreco(),
                itemEntity.isDisponibilidadeDePedirApenasNoRestaurante(),
                itemEntity.getFotoDoPrato());
    }
}
