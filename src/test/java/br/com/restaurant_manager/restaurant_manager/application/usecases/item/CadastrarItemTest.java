package br.com.restaurant_manager.restaurant_manager.application.usecases.item;

import br.com.restaurant_manager.restaurant_manager.application.gateways.cliente.RepositorioDeCliente;
import br.com.restaurant_manager.restaurant_manager.application.gateways.item.RepositorioDeItem;
import br.com.restaurant_manager.restaurant_manager.application.usecases.cliente.CadastrarCliente;
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
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class CadastrarItemTest {

    @Mock
    private RepositorioDeItem repositorioDeItem;

    @InjectMocks
    private CadastrarItem cadastrarItem;

    Item item = new Item("Feijoada Completa", "Feijoada tradicional com arroz, couve e farofa",
            39.90, true, "https://meusite.com/imagens/feijoada.jpg");

    @Test
    void deveCadastrarItem(){

        when(repositorioDeItem.cadastrar(item)).thenReturn(item);

        Item result = cadastrarItem.cadastrarItem(item);

        assertEquals("Feijoada Completa", result.getNome());
        verify(repositorioDeItem, times(1)).cadastrar(item);
    }

}
