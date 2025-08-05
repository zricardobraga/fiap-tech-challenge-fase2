package br.com.restaurant_manager.restaurant_manager.config.item;

import br.com.restaurant_manager.restaurant_manager.application.gateways.item.RepositorioDeItem;
import br.com.restaurant_manager.restaurant_manager.application.usecases.item.*;
import br.com.restaurant_manager.restaurant_manager.infra.gateways.Item.ItemEntityMapper;
import br.com.restaurant_manager.restaurant_manager.infra.gateways.Item.RepositorioDeItemJPA;
import br.com.restaurant_manager.restaurant_manager.infra.persistance.item.repository.ItemRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemConfig {

    @Bean
    RepositorioDeItemJPA criarRepositorioDeItemJPA(ItemRepository itemRepository, ItemEntityMapper itemEntityMapper){
        return new RepositorioDeItemJPA(itemRepository, itemEntityMapper);
    }

    @Bean
    ItemEntityMapper retornarItemEntityMapper(){
        return new ItemEntityMapper();
    }

    @Bean
    CadastrarItem criarCadastrarItem(RepositorioDeItem repositorioDeItem){
        return new CadastrarItem(repositorioDeItem);
    }

    @Bean
    ListarItens listarItens(RepositorioDeItem repositorioDeItem){
        return new ListarItens(repositorioDeItem);
    }

    @Bean
    BuscarItemPorId buscarItemPorId(RepositorioDeItem repositorioDeItem) {
        return new BuscarItemPorId(repositorioDeItem);
    }

    @Bean
    AtualizarItem atualizarItem(RepositorioDeItem repositorioDeItem){
        return new AtualizarItem(repositorioDeItem);
    }

    @Bean
    RemoverItem removerItem(RepositorioDeItem repositorioDeItem){
        return new RemoverItem(repositorioDeItem);
    }

}
