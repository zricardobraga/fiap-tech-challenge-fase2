package br.com.restaurant_manager.restaurant_manager.infra.persistance.restaurante.repository;

import br.com.restaurant_manager.restaurant_manager.infra.persistance.restaurante.entity.RestauranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestauranteRepository extends JpaRepository<RestauranteEntity, Long> {
    Optional<RestauranteEntity> findByNome(String nome);
}
