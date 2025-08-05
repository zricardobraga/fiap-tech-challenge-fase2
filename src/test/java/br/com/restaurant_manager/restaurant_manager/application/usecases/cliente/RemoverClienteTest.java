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

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class RemoverClienteTest {

    @Mock
    private RepositorioDeCliente repositorioDeCliente;

    @InjectMocks
    private RemoverCliente removerCliente;

    Cliente cliente = new Cliente("João da Silva", "joao.silva@google.com",
            "joao.silva", "senha123",
            new Endereco("Rua X", "123", "Casa", "Bairro Z", "Pirapora do Oeste", "PR", "12345678"),
            new TipoUsuario("Cliente"));

    @Test
    void deveRemoveCliente(){
        doNothing().when(repositorioDeCliente).remover(cliente.getId());
        removerCliente.removerCliente(cliente.getId());
        verify(repositorioDeCliente).remover(cliente.getId());
    }
}
