package br.com.restaurant_manager.restaurant_manager.application.usecases.tipoUsuario;

import br.com.restaurant_manager.restaurant_manager.application.gateways.cliente.RepositorioDeCliente;
import br.com.restaurant_manager.restaurant_manager.application.gateways.tipoUsuario.RepositorioDeTipoUsuario;
import br.com.restaurant_manager.restaurant_manager.application.usecases.cliente.ListarClientes;
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
public class ListarTiposUsuarioTest {

    @Mock
    private RepositorioDeTipoUsuario repositorioDeTipoUsuario;

    @InjectMocks
    private ListarTiposUsuario listarTiposUsuario;

    TipoUsuario tipoUsuario1 = new TipoUsuario("Cliente");

    TipoUsuario tipoUsuario2 = new TipoUsuario("Proprietario");

    List<TipoUsuario> tiposUsuario = List.of(tipoUsuario1, tipoUsuario2);

    @Test
    void deveListarTiposUsuario(){

        when(repositorioDeTipoUsuario.listar()).thenReturn(tiposUsuario);

        List<TipoUsuario> result = listarTiposUsuario.listarTodosOsTiposUsuario();

        assertEquals(2, result.size());
        verify(repositorioDeTipoUsuario).listar();
    }

}
