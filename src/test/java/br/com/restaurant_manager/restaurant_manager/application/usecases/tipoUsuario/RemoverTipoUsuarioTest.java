package br.com.restaurant_manager.restaurant_manager.application.usecases.tipoUsuario;

import br.com.restaurant_manager.restaurant_manager.application.gateways.cliente.RepositorioDeCliente;
import br.com.restaurant_manager.restaurant_manager.application.gateways.tipoUsuario.RepositorioDeTipoUsuario;
import br.com.restaurant_manager.restaurant_manager.application.usecases.cliente.RemoverCliente;
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
public class RemoverTipoUsuarioTest {

    @Mock
    private RepositorioDeTipoUsuario repositorioDeTipoUsuario;

    @InjectMocks
    private RemoverTipoUsuario removerTipoUsuario;

    TipoUsuario tipoUsuario = new TipoUsuario(1L, "Cliente");

    @Test
    void deveRemoveCliente(){
        doNothing().when(repositorioDeTipoUsuario).remover(tipoUsuario.getId());
        removerTipoUsuario.removerTipoUsuario(tipoUsuario.getId());
        verify(repositorioDeTipoUsuario).remover(tipoUsuario.getId());
    }
}
