package br.com.restaurant_manager.restaurant_manager.infra.persistance.tipoUsuario.repository;

import br.com.restaurant_manager.restaurant_manager.infra.persistance.tipoUsuario.entity.TipoUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuarioEntity, Long> {
    Optional<TipoUsuarioEntity> findByNomeDoTipo(String nomeDoTipo);
}
