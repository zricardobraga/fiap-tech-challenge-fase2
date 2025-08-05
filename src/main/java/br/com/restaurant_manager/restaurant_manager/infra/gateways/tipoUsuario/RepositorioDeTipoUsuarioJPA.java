package br.com.restaurant_manager.restaurant_manager.infra.gateways.tipoUsuario;

import br.com.restaurant_manager.restaurant_manager.application.gateways.tipoUsuario.RepositorioDeTipoUsuario;
import br.com.restaurant_manager.restaurant_manager.infra.exceptions.ResourceFoundException;
import br.com.restaurant_manager.restaurant_manager.infra.exceptions.ResourceNotFoundException;
import br.com.restaurant_manager.restaurant_manager.infra.persistance.tipoUsuario.entity.TipoUsuarioEntity;
import br.com.restaurant_manager.restaurant_manager.infra.persistance.tipoUsuario.repository.TipoUsuarioRepository;
import br.com.restaurant_manager.restaurant_manager.model.entities.tipoUsuario.TipoUsuario;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeTipoUsuarioJPA implements RepositorioDeTipoUsuario {

    private final TipoUsuarioRepository  tipoUsuarioRepository;
    private final TipoUsuarioEntityMapper tipoUsuarioEntityMapper;

    public RepositorioDeTipoUsuarioJPA(TipoUsuarioRepository tipoUsuarioRepository, TipoUsuarioEntityMapper tipoUsuarioEntityMapper) {
        this.tipoUsuarioRepository = tipoUsuarioRepository;
        this.tipoUsuarioEntityMapper = tipoUsuarioEntityMapper;
    }

    @Override
    public TipoUsuario cadastrar(TipoUsuario tipoUsuario) {
        this.tipoUsuarioRepository.findByNomeDoTipo(tipoUsuario.getNomeDoTipo()).ifPresent(t -> {
            throw new ResourceFoundException("Tipo de usuário já cadastrado");
        });
        TipoUsuarioEntity tipoUsuarioEntity = this.tipoUsuarioEntityMapper.toEntity(tipoUsuario);
        this.tipoUsuarioRepository.save(tipoUsuarioEntity);
        return this.tipoUsuarioEntityMapper.toDomain(tipoUsuarioEntity);
    }

    @Override
    public List<TipoUsuario> listar() {
        return this.tipoUsuarioRepository.findAll().stream().map(tipoUsuarioEntity -> this.tipoUsuarioEntityMapper.toDomain(tipoUsuarioEntity)).collect(Collectors.toList());
    }

    @Override
    public TipoUsuario buscarPorId(Long id) {
        return this.tipoUsuarioRepository.findById(id).map(tipoUsuarioEntityMapper::toDomain).orElseThrow(()-> new ResourceNotFoundException("Tipo de usuário não encontrado"));
    }

    @Override
    public TipoUsuario atualizar(Long id, TipoUsuario tipoUsuario) {
        var tipoUsuarioASerAtualizado = this.tipoUsuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tipo de usuário não encontrado"));

        tipoUsuarioASerAtualizado.setNomeDoTipo(tipoUsuario.getNomeDoTipo());
        this.tipoUsuarioRepository.save(tipoUsuarioASerAtualizado);
        return tipoUsuarioEntityMapper.toDomain(tipoUsuarioASerAtualizado);
    }

    @Override
    public void remover(Long id) {
        this.tipoUsuarioRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Tipo de usuário não encontrado")
        );
        this.tipoUsuarioRepository.deleteById(id);
    }
}
