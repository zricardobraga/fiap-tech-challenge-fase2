package br.com.restaurant_manager.restaurant_manager.infra.gateways.proprietario;

import br.com.restaurant_manager.restaurant_manager.infra.gateways.tipoUsuario.TipoUsuarioEntityMapper;
import br.com.restaurant_manager.restaurant_manager.infra.persistance.proprietario.entity.ProprietarioEntity;
import br.com.restaurant_manager.restaurant_manager.infra.persistance.tipoUsuario.entity.TipoUsuarioEntity;
import br.com.restaurant_manager.restaurant_manager.model.entities.proprietario.Proprietario;

public class ProprietarioEntityMapper {

    private final TipoUsuarioEntityMapper tipoUsuarioEntityMapper = new TipoUsuarioEntityMapper();

    public ProprietarioEntity toEntity(Proprietario proprietario) {
        return new ProprietarioEntity(proprietario.getId(),
                proprietario.getNome(),
                proprietario.getEmail(),
                proprietario.getLogin(),
                proprietario.getSenha(),
                proprietario.getUltimaAlteracao(),
                proprietario.getEndereco(),
                tipoUsuarioEntityMapper.toEntity(proprietario.getTipoUsuario()));
    }

    public Proprietario toDomain(ProprietarioEntity proprietarioEntity) {
        return new Proprietario(proprietarioEntity.getId(),
                proprietarioEntity.getNome(),
                proprietarioEntity.getEmail(),
                proprietarioEntity.getLogin(),
                proprietarioEntity.getSenha(),
                proprietarioEntity.getUltimaAlteracao(),
                proprietarioEntity.getEndereco(),
                tipoUsuarioEntityMapper.toDomain(proprietarioEntity.getTipoUsuarioEntity()));
    }
}
