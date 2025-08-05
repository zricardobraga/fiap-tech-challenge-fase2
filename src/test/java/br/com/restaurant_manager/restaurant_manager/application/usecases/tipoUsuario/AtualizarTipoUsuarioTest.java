package br.com.restaurant_manager.restaurant_manager.application.usecases.tipoUsuario;

import br.com.restaurant_manager.restaurant_manager.application.gateways.tipoUsuario.RepositorioDeTipoUsuario;
import br.com.restaurant_manager.restaurant_manager.model.entities.cliente.Cliente;
import br.com.restaurant_manager.restaurant_manager.model.entities.tipoUsuario.TipoUsuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class AtualizarTipoUsuarioTest {
    @Mock
    private RepositorioDeTipoUsuario repositorioDeTipoUsuario;

    @InjectMocks
    private AtualizarTipoUsuario atualizarTipoUsuario;

    TipoUsuario tipoUsuario = new TipoUsuario("Cliente");

    @Test
    void deveAtualizarTipoUsuario(){

        when(repositorioDeTipoUsuario.atualizar(1L, tipoUsuario)).thenReturn(tipoUsuario);

        TipoUsuario tipoUsuarioASerAtualizado = atualizarTipoUsuario.atualizarTipoUsuario(1L, tipoUsuario);

        assertEquals("Cliente", tipoUsuarioASerAtualizado.getNomeDoTipo());
        verify(repositorioDeTipoUsuario).atualizar(1L, tipoUsuario);
    }

}
