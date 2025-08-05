package br.com.restaurant_manager.restaurant_manager.application.usecases.restaurante;

import br.com.restaurant_manager.restaurant_manager.application.gateways.proprietario.RepositorioDeProprietario;
import br.com.restaurant_manager.restaurant_manager.application.gateways.restaurante.RepositorioDeRestaurante;
import br.com.restaurant_manager.restaurant_manager.application.usecases.proprietario.ListarProprietarios;
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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class ListarRestauranteTest {

    @Mock
    private RepositorioDeRestaurante repositorioDeRestaurante;

    @InjectMocks
    private ListarRestaurantes listarRestaurantes;

    Proprietario proprietario1 = new Proprietario("José das Couves", "jose.couves@google.com",
            "jose.couves", "senha123",
            new Endereco("Rua dos Passarinhos", "999", "Casa", "Bairro Z", "Pirapora do Oeste", "PR", "12345678"),
            new TipoUsuario("Proprietario"));

    Proprietario proprietario2 = new Proprietario("Gerald de Rívia", "gerald.rivia@google.com",
            "gerald.rivia", "senha980",
            new Endereco("Rua dos Passarinhos", "1000", "Casa", "Bairro Z", "Pirapora do Oeste", "PR", "12345678"),
            new TipoUsuario("Proprietario"));

    Restaurante restaurante1 = new Restaurante("Restaurante Sabor Caseiro",
            new Endereco("Rua Y", "222", "Casa", "Foda", "Pirapora do Oeste", "PR", "8025000"),
            TipoDeCozinhaEnum.MINEIRA,
            HorarioDeFuncionamentoEnum.ONZE_AS_QUATORZE,
            proprietario1);

    Restaurante restaurante2 = new Restaurante("Restaurante Caseirinho",
            new Endereco("Rua Y", "400", "Casa", "Foda", "Pirapora do Oeste", "PR", "8025000"),
            TipoDeCozinhaEnum.MINEIRA,
            HorarioDeFuncionamentoEnum.ONZE_AS_QUATORZE,
            proprietario2);

    List<Restaurante> restaurantes = List.of(restaurante1, restaurante2);

    @Test
    void deveListarRestaurante(){

        when(repositorioDeRestaurante.listar()).thenReturn(restaurantes);

        List<Restaurante> result = listarRestaurantes.listarTodosOsRestaurantes();

        assertEquals(2, result.size());
        verify(repositorioDeRestaurante).listar();
    }

}
