package br.com.restaurant_manager.restaurant_manager.infra.gateways.tipoUsuario;

import br.com.restaurant_manager.restaurant_manager.infra.persistance.tipoUsuario.entity.TipoUsuarioEntity;
import br.com.restaurant_manager.restaurant_manager.model.entities.tipoUsuario.TipoUsuario;

public class TipoUsuarioEntityMapper {

    public TipoUsuarioEntity toEntity(TipoUsuario tipoUsuario) {
        return new TipoUsuarioEntity(tipoUsuario.getId(), tipoUsuario.getNomeDoTipo());
    }

    public TipoUsuario toDomain(TipoUsuarioEntity tipoUsuarioEntity) {
        return new TipoUsuario(tipoUsuarioEntity.getId(), tipoUsuarioEntity.getNomeDoTipo());
    }
}
