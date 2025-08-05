package br.com.restaurant_manager.restaurant_manager.application.usecases.item;

import br.com.restaurant_manager.restaurant_manager.application.gateways.cliente.RepositorioDeCliente;
import br.com.restaurant_manager.restaurant_manager.application.gateways.item.RepositorioDeItem;
import br.com.restaurant_manager.restaurant_manager.application.usecases.cliente.BuscarClientePorId;
import br.com.restaurant_manager.restaurant_manager.model.Endereco;
import br.com.restaurant_manager.restaurant_manager.model.entities.cliente.Cliente;
import br.com.restaurant_manager.restaurant_manager.model.entities.item.Item;
import br.com.restaurant_manager.restaurant_manager.model.entities.tipoUsuario.TipoUsuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.AssertionsKt.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class BuscarItemPorIdTest {

    @Mock
    private RepositorioDeItem repositorioDeItem;

    @InjectMocks
    private BuscarItemPorId buscarItemPorId;

    Item item = new Item(1L,"Feijoada Completa", "Feijoada tradicional com arroz, couve e farofa",
            39.90, true, "https://meusite.com/imagens/feijoada.jpg");

    @Test
    void deveBuscarItemPorId(){

        when(repositorioDeItem.buscarPorId(item.getId())).thenReturn(item);

        Item result = buscarItemPorId.buscarItemPorId(item.getId());

        assertNotNull(result);
        assertEquals("Feijoada Completa", result.getNome());
        verify(repositorioDeItem).buscarPorId(item.getId());
    }
}
