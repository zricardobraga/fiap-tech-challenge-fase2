package br.com.restaurant_manager.restaurant_manager.application.usecases.item;

import br.com.restaurant_manager.restaurant_manager.application.gateways.cliente.RepositorioDeCliente;
import br.com.restaurant_manager.restaurant_manager.application.gateways.item.RepositorioDeItem;
import br.com.restaurant_manager.restaurant_manager.application.usecases.cliente.RemoverCliente;
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

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class RemoverItemTest {

    @Mock
    private RepositorioDeItem repositorioDeItem;

    @InjectMocks
    private RemoverItem removerItem;

    Item item = new Item(1L,"Feijoada Completa", "Feijoada tradicional com arroz, couve e farofa",
            39.90, true, "https://meusite.com/imagens/feijoada.jpg");

    @Test
    void deveRemoveItem(){
        doNothing().when(repositorioDeItem).remover(item.getId());
        removerItem.removerItem(item.getId());
        verify(repositorioDeItem).remover(item.getId());
    }
}
