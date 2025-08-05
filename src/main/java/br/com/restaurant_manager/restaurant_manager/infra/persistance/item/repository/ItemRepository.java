package br.com.restaurant_manager.restaurant_manager.infra.persistance.item.repository;

import br.com.restaurant_manager.restaurant_manager.infra.persistance.item.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
    Optional<ItemEntity> findByNome(String nome);
}
