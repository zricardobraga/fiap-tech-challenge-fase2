package br.com.restaurant_manager.restaurant_manager.application.usecases.cliente;

import br.com.restaurant_manager.restaurant_manager.application.gateways.cliente.RepositorioDeCliente;
import br.com.restaurant_manager.restaurant_manager.model.Endereco;
import br.com.restaurant_manager.restaurant_manager.model.entities.cliente.Cliente;
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
public class BuscarClientePorIdTest {

    @Mock
    private RepositorioDeCliente repositorioDeCliente;

    @InjectMocks
    private BuscarClientePorId buscarClientePorId;

    Cliente cliente = new Cliente("João da Silva", "joao.silva@google.com",
            "joao.silva", "senha123",
            new Endereco("Rua X", "123", "Casa", "Bairro Z", "Pirapora do Oeste", "PR", "12345678"),
            new TipoUsuario("Cliente"));

    @Test
    void deveBuscarClientePorId(){

        when(repositorioDeCliente.buscarPorId(cliente.getId())).thenReturn(cliente);

        Cliente result = buscarClientePorId.buscarClientePorId(cliente.getId());

        assertNotNull(result);
        assertEquals("João da Silva", result.getNome());
        verify(repositorioDeCliente).buscarPorId(cliente.getId());
    }
}
