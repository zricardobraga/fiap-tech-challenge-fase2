package br.com.restaurant_manager.restaurant_manager.infra.gateways.restaurante;

import br.com.restaurant_manager.restaurant_manager.infra.gateways.proprietario.ProprietarioEntityMapper;
import br.com.restaurant_manager.restaurant_manager.infra.persistance.proprietario.entity.ProprietarioEntity;
import br.com.restaurant_manager.restaurant_manager.infra.persistance.restaurante.entity.RestauranteEntity;
import br.com.restaurant_manager.restaurant_manager.model.entities.proprietario.Proprietario;
import br.com.restaurant_manager.restaurant_manager.model.entities.restaurante.Restaurante;

public class RestauranteEntityMapper {

    private final ProprietarioEntityMapper proprietarioEntityMapper = new ProprietarioEntityMapper();

    public RestauranteEntity toEntity(Restaurante restaurante) {
        ProprietarioEntity donoDoRestauranteEntity = proprietarioEntityMapper.toEntity(restaurante.getDonoDoRestaurante());
        return new RestauranteEntity(restaurante.getId(), restaurante.getNome(), restaurante.getEndereco(),
                restaurante.getTipoDeCozinha(), restaurante.getHorarioDeFuncionamento(), donoDoRestauranteEntity);
    }

    public Restaurante toDomain(RestauranteEntity restauranteEntity) {
        Proprietario donoDoRestauranteDomain = proprietarioEntityMapper.toDomain(restauranteEntity.getDonoDoRestaurante());
        return new Restaurante(restauranteEntity.getId(), restauranteEntity.getNome(), restauranteEntity.getEndereco(),
                restauranteEntity.getTipoDeCozinha(), restauranteEntity.getHorarioDeFuncionamento(), donoDoRestauranteDomain);
    }
}
