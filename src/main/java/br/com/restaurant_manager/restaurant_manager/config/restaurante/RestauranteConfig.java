package br.com.restaurant_manager.restaurant_manager.config.restaurante;

import br.com.restaurant_manager.restaurant_manager.application.gateways.restaurante.RepositorioDeRestaurante;
import br.com.restaurant_manager.restaurant_manager.application.usecases.restaurante.*;
import br.com.restaurant_manager.restaurant_manager.infra.gateways.restaurante.RepositorioDeRestauranteJPA;
import br.com.restaurant_manager.restaurant_manager.infra.gateways.restaurante.RestauranteEntityMapper;
import br.com.restaurant_manager.restaurant_manager.infra.persistance.proprietario.repository.ProprietarioRepository;
import br.com.restaurant_manager.restaurant_manager.infra.persistance.restaurante.repository.RestauranteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestauranteConfig {

    @Bean
    RepositorioDeRestauranteJPA criarRepositorioDeRestauranteJPA(RestauranteRepository restauranteRepository, ProprietarioRepository proprietarioRepository, RestauranteEntityMapper restauranteEntityMapper){
        return new RepositorioDeRestauranteJPA(restauranteRepository, proprietarioRepository, restauranteEntityMapper);
    }

    @Bean
    RestauranteEntityMapper RestauranteEntityMapper(){
        return new RestauranteEntityMapper();
    }

    @Bean
    CadastrarRestaurante criarRestaurante(RepositorioDeRestaurante repositorioDeRestaurante){
        return new CadastrarRestaurante(repositorioDeRestaurante);
    }

    @Bean
    ListarRestaurantes listarRestaurante(RepositorioDeRestaurante repositorioDeRestaurante){
        return new ListarRestaurantes (repositorioDeRestaurante);
    }

    @Bean
    BuscarRestaurantePorId buscarRestaurantePorId(RepositorioDeRestaurante repositorioDeRestaurante){
        return new BuscarRestaurantePorId(repositorioDeRestaurante);
    }

    @Bean
    AtualizarRestaurante atualizarRestaurante(RepositorioDeRestaurante repositorioDeRestaurante){
        return new AtualizarRestaurante(repositorioDeRestaurante);
    }

    @Bean
    RemoverRestaurante apagarRestaurante(RepositorioDeRestaurante repositorioDeRestaurante){
        return new RemoverRestaurante(repositorioDeRestaurante);
    }
}
