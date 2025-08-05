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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class ListarClientesTest {

    @Mock
    private RepositorioDeCliente repositorioDeCliente;

    @InjectMocks
    private ListarClientes listarClientes;

    Cliente cliente1 = new Cliente("João da Silva", "joao.silva@google.com",
            "joao.silva", "senha123",
            new Endereco("Rua X", "123", "Casa", "Bairro Z", "Pirapora do Oeste", "PR", "12345678"),
            new TipoUsuario("Cliente"));

    Cliente cliente2 = new Cliente("Pedro Malazarte", "pedro.malazarte@google.com",
            "pedro.malazarte", "senha123",
            new Endereco("Rua Y", "456", "Casa", "Bairro Y", "Pirapora do Oeste", "PR", "12345678"),
            new TipoUsuario("Cliente"));

    List<Cliente> clientes = List.of(cliente1, cliente2);

    @Test
    void deveListarClientes(){

        when(repositorioDeCliente.listar()).thenReturn(clientes);

        List<Cliente> result = listarClientes.listarTodosOsClientes();

        assertEquals(2, result.size());
        verify(repositorioDeCliente).listar();
    }

}
