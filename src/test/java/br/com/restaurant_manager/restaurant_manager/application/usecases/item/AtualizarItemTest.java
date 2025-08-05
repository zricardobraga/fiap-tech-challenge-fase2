package br.com.restaurant_manager.restaurant_manager.application.usecases.item;

import br.com.restaurant_manager.restaurant_manager.application.gateways.cliente.RepositorioDeCliente;
import br.com.restaurant_manager.restaurant_manager.application.gateways.item.RepositorioDeItem;
import br.com.restaurant_manager.restaurant_manager.application.usecases.cliente.AtualizarCliente;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class AtualizarItemTest {
    @Mock
    private RepositorioDeItem repositorioDeItem;

    @InjectMocks
    private AtualizarItem atualizarItem;

    Item item = new Item("Feijoada Completa", "Feijoada tradicional com arroz, couve e farofa",
            39.90, true, "https://meusite.com/imagens/feijoada.jpg");

    @Test
    void deveAtualizarItem(){

        when(repositorioDeItem.atualizar(1L, item)).thenReturn(item);

        Item itemASerAtualizado = atualizarItem.atualizarItem(1L, item);

        assertEquals("Feijoada Completa", itemASerAtualizado.getNome());
        verify(repositorioDeItem).atualizar(1L, item);
    }

}
