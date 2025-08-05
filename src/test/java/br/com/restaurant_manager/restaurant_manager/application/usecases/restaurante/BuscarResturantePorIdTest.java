package br.com.restaurant_manager.restaurant_manager.application.usecases.restaurante;

import br.com.restaurant_manager.restaurant_manager.application.gateways.proprietario.RepositorioDeProprietario;
import br.com.restaurant_manager.restaurant_manager.application.gateways.restaurante.RepositorioDeRestaurante;
import br.com.restaurant_manager.restaurant_manager.application.usecases.proprietario.BuscarProprietarioPorId;
import br.com.restaurant_manager.restaurant_manager.model.ENUM.HorarioDeFuncionamentoEnum;
import br.com.restaurant_manager.restaurant_manager.model.ENUM.TipoDeCozinhaEnum;
import br.com.restaurant_manager.restaurant_manager.model.Endereco;
import br.com.restaurant_manager.restaurant_manager.model.entities.proprietario.Proprietario;
import br.com.restaurant_manager.restaurant_manager.model.entities.restaurante.Restaurante;
import br.com.restaurant_manager.restaurant_manager.model.entities.tipoUsuario.TipoUsuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.AssertionsKt.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class BuscarResturantePorIdTest {

    @Mock
    private RepositorioDeRestaurante repositorioDeRestaurante;

    @InjectMocks
    private BuscarRestaurantePorId buscarRestaurantePorId;

    Proprietario proprietario = new Proprietario(1L, "José das Couves", "jose.couves@google.com",
            "jose.couves", "senha123", new Date(),
            new Endereco("Rua dos Passarinhos", "999", "Casa", "Bairro Z", "Pirapora do Oeste", "PR", "12345678"),
            new TipoUsuario("Proprietario"));

    Restaurante restaurante = new Restaurante("Restaurante Sabor Caseiro",
            new Endereco("Rua Y", "222", "Casa", "Foda", "Pirapora do Oeste", "PR", "8025000"),
            TipoDeCozinhaEnum.MINEIRA,
            HorarioDeFuncionamentoEnum.ONZE_AS_QUATORZE,
            proprietario);

    @Test
    void deveBuscarRestaurantePorId(){

        when(repositorioDeRestaurante.buscarPorId(restaurante.getId())).thenReturn(restaurante);

        Restaurante result = buscarRestaurantePorId.buscarRestaurantePorId(restaurante.getId());

        assertNotNull(result);
        assertEquals("Restaurante Sabor Caseiro", result.getNome());
        verify(repositorioDeRestaurante).buscarPorId(restaurante.getId());
    }
}
