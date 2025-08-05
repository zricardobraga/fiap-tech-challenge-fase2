package br.com.restaurant_manager.restaurant_manager.application.usecases.tipoUsuario;

import br.com.restaurant_manager.restaurant_manager.application.gateways.cliente.RepositorioDeCliente;
import br.com.restaurant_manager.restaurant_manager.application.gateways.tipoUsuario.RepositorioDeTipoUsuario;
import br.com.restaurant_manager.restaurant_manager.application.usecases.cliente.BuscarClientePorId;
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
public class BuscarTipoUsuarioPorIdTest {

    @Mock
    private RepositorioDeTipoUsuario repositorioDeTipoUsuario;

    @InjectMocks
    private BuscarTipoUsuarioPorId buscarTipoUsuarioPorId;

    TipoUsuario tipoUsuario = new TipoUsuario(1L,"Cliente");

    @Test
    void deveBuscarTipoUsuarioPorId(){

        when(repositorioDeTipoUsuario.buscarPorId(tipoUsuario.getId())).thenReturn(tipoUsuario);

        TipoUsuario result = buscarTipoUsuarioPorId.buscarTipoUsuarioPorId(tipoUsuario.getId());

        assertNotNull(result);
        assertEquals("Cliente", result.getNomeDoTipo());
        verify(repositorioDeTipoUsuario).buscarPorId(tipoUsuario.getId());
    }
}
