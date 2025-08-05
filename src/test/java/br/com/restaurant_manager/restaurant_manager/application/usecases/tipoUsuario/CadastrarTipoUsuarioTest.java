package br.com.restaurant_manager.restaurant_manager.application.usecases.tipoUsuario;

import br.com.restaurant_manager.restaurant_manager.application.gateways.tipoUsuario.RepositorioDeTipoUsuario;
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
public class CadastrarTipoUsuarioTest {

    @Mock
    private RepositorioDeTipoUsuario repositorioDeTipoUsuario;

    @InjectMocks
    private CadastrarTipoUsuario cadastrarTipoUsuario;

    TipoUsuario tipoUsuario = new TipoUsuario("Cliente");

    @Test
    void deveCadastrarTipoUsuario(){

        when(repositorioDeTipoUsuario.cadastrar(tipoUsuario)).thenReturn(tipoUsuario);

        TipoUsuario result = cadastrarTipoUsuario.cadatrarTipoUsuario(tipoUsuario);

        assertEquals("Cliente", result.getNomeDoTipo());
        verify(repositorioDeTipoUsuario, times(1)).cadastrar(tipoUsuario);
    }

}
