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
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class CadastrarClienteTest {

    @Mock
    private RepositorioDeCliente repositorioDeCliente;

    @InjectMocks
    private CadastrarCliente cadastrarCliente;

    Cliente cliente = new Cliente("João da Silva", "joao.silva@google.com",
            "joao.silva", "senha123",
            new Endereco("Rua X", "123", "Casa", "Bairro Z", "Pirapora do Oeste", "PR", "12345678"),
            new TipoUsuario("Cliente"));

    @Test
    void deveCadastrarCliente(){

        when(repositorioDeCliente.cadastrar(cliente)).thenReturn(cliente);

        Cliente result = cadastrarCliente.cadastrarCliente(cliente);

        assertEquals("João da Silva", result.getNome());
        verify(repositorioDeCliente, times(1)).cadastrar(cliente);
    }

}
