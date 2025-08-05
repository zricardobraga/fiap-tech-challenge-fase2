package br.com.restaurant_manager.restaurant_manager.infra.gateways.proprietario;

import br.com.restaurant_manager.restaurant_manager.application.gateways.proprietario.RepositorioDeProprietario;
import br.com.restaurant_manager.restaurant_manager.infra.exceptions.ResourceFoundException;
import br.com.restaurant_manager.restaurant_manager.infra.exceptions.ResourceNotFoundException;
import br.com.restaurant_manager.restaurant_manager.infra.persistance.proprietario.entity.ProprietarioEntity;
import br.com.restaurant_manager.restaurant_manager.infra.persistance.proprietario.repository.ProprietarioRepository;
import br.com.restaurant_manager.restaurant_manager.infra.persistance.tipoUsuario.entity.TipoUsuarioEntity;
import br.com.restaurant_manager.restaurant_manager.infra.persistance.tipoUsuario.repository.TipoUsuarioRepository;
import br.com.restaurant_manager.restaurant_manager.model.entities.proprietario.Proprietario;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class RepositorioDeProprietarioJPA implements RepositorioDeProprietario {

    private final ProprietarioRepository proprietarioRepository;
    private final ProprietarioEntityMapper proprietarioEntityMapper;
    private final TipoUsuarioRepository tipoUsuarioRepository;

    public RepositorioDeProprietarioJPA(ProprietarioRepository proprietarioRepository, ProprietarioEntityMapper proprietarioEntityMapper, TipoUsuarioRepository tipoUsuarioRepository) {
        this.proprietarioRepository = proprietarioRepository;
        this.proprietarioEntityMapper = proprietarioEntityMapper;
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    @Override
    public Proprietario cadastrar(Proprietario proprietario) {
        this.proprietarioRepository.findByEmail(proprietario.getEmail()).ifPresent(p -> {
            throw new ResourceFoundException("E-mail já cadastrado no sistema");
        });
        this.proprietarioRepository.findByLogin(proprietario.getLogin()).ifPresent(p -> {
            throw new ResourceFoundException("Proprietário já cadastrado no sistema");
        });

        TipoUsuarioEntity tipoUsuarioEntity = buscarTipoUsuario(proprietario.getTipoUsuario().getId()).orElseThrow(
                () -> new ResourceNotFoundException("Tipo de usuário não encontrado"));

        proprietario.setUltimaAlteracao(new Date());
        ProprietarioEntity proprietarioEntity = this.proprietarioEntityMapper.toEntity(proprietario);
        proprietarioEntity.setTipoUsuarioEntity(tipoUsuarioEntity);
        this.proprietarioRepository.save(proprietarioEntity);
        return this.proprietarioEntityMapper.toDomain(proprietarioEntity);
    }

    @Override
    public List<Proprietario> listar() {
        return this.proprietarioRepository.findAll().stream().map(proprietarioEntityMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Proprietario buscarPorId(Long id) {
        return this.proprietarioRepository.findById(id)
                .map(proprietarioEntityMapper::toDomain)
                .orElseThrow(() -> new ResourceNotFoundException("Proprietário não encontrado"));
    }

    @Override
    public Proprietario atualizar(Long id, Proprietario proprietario) {
        var proprietarioASerAtualizado = this.proprietarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proprietário não encontrado"));

        TipoUsuarioEntity tipoUsuarioEntity = buscarTipoUsuario(proprietario.getTipoUsuario().getId()).orElseThrow(
                () -> new ResourceNotFoundException("Tipo de usuário não encontrado"));

        proprietarioASerAtualizado.setNome(proprietario.getNome());
        proprietarioASerAtualizado.setEmail(proprietario.getEmail());
        proprietarioASerAtualizado.setLogin(proprietario.getLogin());
        proprietarioASerAtualizado.setSenha(proprietario.getSenha());
        proprietarioASerAtualizado.setUltimaAlteracao(new Date());
        proprietarioASerAtualizado.setEndereco(proprietario.getEndereco());
        proprietarioASerAtualizado.setTipoUsuarioEntity(tipoUsuarioEntity);
        this.proprietarioRepository.save(proprietarioASerAtualizado);

        return proprietarioEntityMapper.toDomain(proprietarioASerAtualizado);
    }

    @Override
    public void remover(Long id) {
        this.proprietarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proprietário não encontrado"));

        this.proprietarioRepository.deleteById(id);
    }

    @Override
    public String trocarSenha(Long id, String senha) {
        var proprietarioQueTeraASenhaAtualizada = this.proprietarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proprietário não encontrado"));

        Date ultimaAtualizacao = new Date();
        proprietarioQueTeraASenhaAtualizada.setSenha(senha);
        proprietarioQueTeraASenhaAtualizada.setUltimaAlteracao(ultimaAtualizacao);

        this.proprietarioRepository.save(proprietarioQueTeraASenhaAtualizada);

        String result = "Senha alterada com sucesso";

        return result;
    }

    @Override
    public String validarAcesso(String login, String senha) {
        var proprietarioQueTeraOLoginValidado = this.proprietarioRepository.findByLogin(login).orElseThrow(() -> new ResourceNotFoundException("Login não encontrado"));
        if(!proprietarioQueTeraOLoginValidado.getSenha().equals(senha)) {
            throw new ResourceNotFoundException("Senha incorreta");
        }

        var result = "Login realizado com sucesso";

        return result;
    }

    private Optional<TipoUsuarioEntity> buscarTipoUsuario(Long id) {
        return this.tipoUsuarioRepository.findById(id);
    }
}
