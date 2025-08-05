package br.com.restaurant_manager.restaurant_manager.application.usecases.item;

import br.com.restaurant_manager.restaurant_manager.application.gateways.item.RepositorioDeItem;
import br.com.restaurant_manager.restaurant_manager.model.entities.item.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class ListarItensTest {

    @Mock
    private RepositorioDeItem repositorioDeItem;

    @InjectMocks
    private ListarItens listarItens;

    Item item1 = new Item(1L,"Arroz à grega", "Arroz cozido com passas e frutas cristalizadas",
            23.90, true, "https://meusite.com/imagens/arrozagrega.jpg");

    Item item2 = new Item(2L,"Feijoada Completa", "Feijoada tradicional com arroz, couve e farofa",
            39.90, true, "https://meusite.com/imagens/feijoada.jpg");

    List<Item> Itens = List.of(item1, item2);

    @Test
    void deveListarItens(){

        when(repositorioDeItem.listar()).thenReturn(Itens);

        List<Item> result = listarItens.listarTodosOsItens();

        assertEquals(2, result.size());
        verify(repositorioDeItem).listar();
    }

}
