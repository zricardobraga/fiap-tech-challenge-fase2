package br.com.restaurant_manager.restaurant_manager.infra.gateways.cliente;

import br.com.restaurant_manager.restaurant_manager.application.gateways.cliente.RepositorioDeCliente;
import br.com.restaurant_manager.restaurant_manager.infra.exceptions.ResourceFoundException;
import br.com.restaurant_manager.restaurant_manager.infra.exceptions.ResourceNotFoundException;
import br.com.restaurant_manager.restaurant_manager.infra.persistance.cliente.entity.ClienteEntity;
import br.com.restaurant_manager.restaurant_manager.infra.persistance.cliente.repository.ClienteRepository;
import br.com.restaurant_manager.restaurant_manager.infra.persistance.tipoUsuario.entity.TipoUsuarioEntity;
import br.com.restaurant_manager.restaurant_manager.infra.persistance.tipoUsuario.repository.TipoUsuarioRepository;
import br.com.restaurant_manager.restaurant_manager.model.entities.cliente.Cliente;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RepositorioDeClienteJPA implements RepositorioDeCliente {

    private final ClienteRepository clienteRepository;
    private final TipoUsuarioRepository tipoUsuarioRepository;
    private final ClienteEntityMapper clienteEntityMapper;

    public RepositorioDeClienteJPA(ClienteRepository clienteRepository, TipoUsuarioRepository tipoUsuarioRepository, ClienteEntityMapper clienteEntityMapper) {
        this.clienteRepository = clienteRepository;
        this.tipoUsuarioRepository = tipoUsuarioRepository;
        this.clienteEntityMapper = clienteEntityMapper;
    }

    @Override
    public Cliente cadastrar(Cliente cliente) {
        this.clienteRepository.findByEmail(cliente.getEmail()).ifPresent(
                c -> {
                    throw new ResourceFoundException("E-mail já cadastrado no sistema");
                }
        );
        this.clienteRepository.findByLogin(cliente.getLogin()).ifPresent(
                c -> {
                    throw new ResourceFoundException("Login já cadastrado no sistema");
                }
        );

        TipoUsuarioEntity tipoUsuarioEntity = buscarTipoUsuario(cliente.getTipoUsuario().getId()).orElseThrow(
                () -> new ResourceNotFoundException("Tipo de usuário não encontrado"));

        cliente.setUltimaAlteracao(new Date());
        ClienteEntity clienteEntity = this.clienteEntityMapper.toEntity(cliente);
        clienteEntity.setTipoUsuarioEntity(tipoUsuarioEntity);
        this.clienteRepository.save(clienteEntity);
        return this.clienteEntityMapper.toDomain(clienteEntity);
    }

    @Override
    public List<Cliente> listar() {
        return this.clienteRepository.findAll().stream().map(this.clienteEntityMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return this.clienteRepository.findById(id)
                .map(clienteEntityMapper::toDomain)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
    }

    @Override
    public Cliente atualizar(Long id, Cliente cliente) {
        var clienteASerAtualizado = this.clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        TipoUsuarioEntity tipoUsuarioEntity = buscarTipoUsuario(cliente.getTipoUsuario().getId()).orElseThrow(
                () -> new ResourceNotFoundException("Tipo de usuário não encontrado"));

        clienteASerAtualizado.setNome(cliente.getNome());
        clienteASerAtualizado.setEmail(cliente.getEmail());
        clienteASerAtualizado.setLogin(cliente.getLogin());
        clienteASerAtualizado.setSenha(cliente.getSenha());
        clienteASerAtualizado.setUltimaAlteracao(new Date());
        clienteASerAtualizado.setEndereco(cliente.getEndereco());
        clienteASerAtualizado.setTipoUsuarioEntity(tipoUsuarioEntity);

        this.clienteRepository.save(clienteASerAtualizado);

        return clienteEntityMapper.toDomain(clienteASerAtualizado);
    }

    @Override
    public String trocarSenha(Long id, String senha) {
        var clienteQueTeraASenhaAtualizada = this.clienteRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("Cliente não encontrado");
        });

        clienteQueTeraASenhaAtualizada.setSenha(senha);
        clienteQueTeraASenhaAtualizada.setUltimaAlteracao(new Date());

        this.clienteRepository.save(clienteQueTeraASenhaAtualizada);

        String result = "Senha alterada com sucesso";
        return result;
    }

    @Override
    public void remover(Long id) {
        this.clienteRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("Cliente não encontrado");
        });
            this.clienteRepository.deleteById(id);
    }

    @Override
    public String validarAcesso(String login, String senha) {
        var clienteQueTeraOLoginValidado = this.clienteRepository.findByLogin(login).orElseThrow(() -> new ResourceNotFoundException("Login não encontrado"));
        if(!clienteQueTeraOLoginValidado.getSenha().equals(senha)) {
            throw new ResourceNotFoundException("Senha incorreta");
        }
        var result = "Login realizado com sucesso";
        return result;
    }

    private Optional<TipoUsuarioEntity> buscarTipoUsuario(Long id) {
        return this.tipoUsuarioRepository.findById(id);
    }
}
