package br.com.restaurant_manager.restaurant_manager.config.tipoDeUsuario;

import br.com.restaurant_manager.restaurant_manager.application.gateways.tipoUsuario.RepositorioDeTipoUsuario;
import br.com.restaurant_manager.restaurant_manager.application.usecases.tipoUsuario.*;
import br.com.restaurant_manager.restaurant_manager.infra.gateways.tipoUsuario.RepositorioDeTipoUsuarioJPA;
import br.com.restaurant_manager.restaurant_manager.infra.gateways.tipoUsuario.TipoUsuarioEntityMapper;
import br.com.restaurant_manager.restaurant_manager.infra.persistance.tipoUsuario.repository.TipoUsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TipoUsuarioConfig {

    @Bean
    RepositorioDeTipoUsuarioJPA criarRepositorioDeTipoUsuarioJPA(TipoUsuarioRepository tipoUsuarioRepository, TipoUsuarioEntityMapper tipoUsuarioEntityMapper){
        return new RepositorioDeTipoUsuarioJPA(tipoUsuarioRepository, tipoUsuarioEntityMapper);
    }

    @Bean
    TipoUsuarioEntityMapper retornarTipoUsuarioEntityMapper(){
        return new TipoUsuarioEntityMapper();
    }

    @Bean
    CadastrarTipoUsuario criarTipoUsuario(RepositorioDeTipoUsuario  repositorioDeTipoUsuario){
        return new CadastrarTipoUsuario(repositorioDeTipoUsuario);
    }

    @Bean
    ListarTiposUsuario listarTiposUsuario(RepositorioDeTipoUsuario  repositorioDeTipoUsuario){
        return new ListarTiposUsuario(repositorioDeTipoUsuario);
    }

    @Bean
    BuscarTipoUsuarioPorId buscarTipoUsuarioPorId(RepositorioDeTipoUsuario  repositorioDeTipoUsuario){
        return new BuscarTipoUsuarioPorId(repositorioDeTipoUsuario);
    }

    @Bean
    AtualizarTipoUsuario atualizarTipoUsuario(RepositorioDeTipoUsuario  repositorioDeTipoUsuario){
        return new AtualizarTipoUsuario(repositorioDeTipoUsuario);
    }

    @Bean
    RemoverTipoUsuario apagarTipoUsuario(RepositorioDeTipoUsuario  repositorioDeTipoUsuario){
        return new RemoverTipoUsuario(repositorioDeTipoUsuario);
    }

}

