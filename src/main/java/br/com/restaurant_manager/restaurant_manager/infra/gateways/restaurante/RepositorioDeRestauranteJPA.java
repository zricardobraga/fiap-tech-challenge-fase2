package br.com.restaurant_manager.restaurant_manager.infra.gateways.restaurante;

import br.com.restaurant_manager.restaurant_manager.application.gateways.restaurante.RepositorioDeRestaurante;
import br.com.restaurant_manager.restaurant_manager.infra.exceptions.ResourceFoundException;
import br.com.restaurant_manager.restaurant_manager.infra.exceptions.ResourceNotFoundException;
import br.com.restaurant_manager.restaurant_manager.infra.persistance.proprietario.entity.ProprietarioEntity;
import br.com.restaurant_manager.restaurant_manager.infra.persistance.proprietario.repository.ProprietarioRepository;
import br.com.restaurant_manager.restaurant_manager.infra.persistance.restaurante.entity.RestauranteEntity;
import br.com.restaurant_manager.restaurant_manager.infra.persistance.restaurante.repository.RestauranteRepository;
import br.com.restaurant_manager.restaurant_manager.model.entities.restaurante.Restaurante;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeRestauranteJPA implements RepositorioDeRestaurante {

    private final RestauranteRepository restauranteRepository;
    private final ProprietarioRepository proprietarioRepository;
    private final RestauranteEntityMapper restauranteEntityMapper;

    public RepositorioDeRestauranteJPA(RestauranteRepository restauranteRepository, ProprietarioRepository proprietarioRepository,
                                       RestauranteEntityMapper restauranteEntityMapper) {
        this.restauranteRepository = restauranteRepository;
        this.proprietarioRepository = proprietarioRepository;
        this.restauranteEntityMapper = restauranteEntityMapper;
    }

    @Override
    public Restaurante cadastrar(Restaurante restaurante) {
        this.restauranteRepository.findByNome(restaurante.getNome()).ifPresent(restauranteEntity -> {
            throw new ResourceFoundException("Restaurante já cadastrado");
        });
        ProprietarioEntity donoDoRestauranteEntity = this.proprietarioRepository.findById(restaurante.getDonoDoRestaurante().getId()).orElseThrow(
                () -> new ResourceNotFoundException("Proprietário não localizado")
        );
        RestauranteEntity restauranteEntity = restauranteEntityMapper.toEntity(restaurante);
        restauranteEntity.setDonoDoRestaurante(donoDoRestauranteEntity);
        this.restauranteRepository.save(restauranteEntity);
        return restauranteEntityMapper.toDomain(restauranteEntity);
    }

    @Override
    public List<Restaurante> listar() {
        return this.restauranteRepository.findAll().stream().map(restauranteEntityMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Restaurante buscarPorId(Long id) {
        return this.restauranteRepository.findById(id)
                .map(restauranteEntityMapper::toDomain)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurante não encontrado")
        );
    }

    @Override
    public Restaurante atualizar(Long id, Restaurante restaurante) {
        var restauranteASerAtualizado = this.restauranteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Restaurante não encontrado"));
        ProprietarioEntity donoDoRestauranteEntity = this.proprietarioRepository.findById(restaurante.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Proprietário não localizado")
        );
        restauranteASerAtualizado.setNome(restaurante.getNome());
        restauranteASerAtualizado.setEndereco(restaurante.getEndereco());
        restauranteASerAtualizado.setTipoDeCozinha(restaurante.getTipoDeCozinha());
        restauranteASerAtualizado.setHorarioDeFuncionamento(restaurante.getHorarioDeFuncionamento());
        restauranteASerAtualizado.setDonoDoRestaurante(donoDoRestauranteEntity);
        this.restauranteRepository.save(restauranteASerAtualizado);
        return restauranteEntityMapper.toDomain(restauranteASerAtualizado);
    }

    @Override
    public void remover(Long id) {
        this.restauranteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Restaurante não encontrado"));
        this.restauranteRepository.deleteById(id);
    }
}
