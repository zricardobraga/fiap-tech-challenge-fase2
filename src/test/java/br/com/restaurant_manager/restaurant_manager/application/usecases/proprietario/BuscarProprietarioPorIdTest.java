package br.com.restaurant_manager.restaurant_manager.application.usecases.proprietario;

import br.com.restaurant_manager.restaurant_manager.application.gateways.cliente.RepositorioDeCliente;
import br.com.restaurant_manager.restaurant_manager.application.gateways.proprietario.RepositorioDeProprietario;
import br.com.restaurant_manager.restaurant_manager.application.usecases.cliente.BuscarClientePorId;
import br.com.restaurant_manager.restaurant_manager.model.Endereco;
import br.com.restaurant_manager.restaurant_manager.model.entities.cliente.Cliente;
import br.com.restaurant_manager.restaurant_manager.model.entities.proprietario.Proprietario;
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
public class BuscarProprietarioPorIdTest {

    @Mock
    private RepositorioDeProprietario repositorioDeProprietario;

    @InjectMocks
    private BuscarProprietarioPorId buscarProprietarioPorId;

    Proprietario proprietario = new Proprietario("José das Couves", "jose.couves@google.com",
            "jose.couves", "senha123",
            new Endereco("Rua dos Passarinhos", "999", "Casa", "Bairro Z", "Pirapora do Oeste", "PR", "12345678"),
            new TipoUsuario("Proprietario"));

    @Test
    void deveBuscarClientePorId(){

        when(repositorioDeProprietario.buscarPorId(proprietario.getId())).thenReturn(proprietario);

        Proprietario result = buscarProprietarioPorId.buscarProprietarioPorId(proprietario.getId());

        assertNotNull(result);
        assertEquals("José das Couves", result.getNome());
        verify(repositorioDeProprietario).buscarPorId(proprietario.getId());
    }
}
