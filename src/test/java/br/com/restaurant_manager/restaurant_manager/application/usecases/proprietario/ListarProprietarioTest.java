package br.com.restaurant_manager.restaurant_manager.application.usecases.proprietario;

import br.com.restaurant_manager.restaurant_manager.application.gateways.cliente.RepositorioDeCliente;
import br.com.restaurant_manager.restaurant_manager.application.gateways.proprietario.RepositorioDeProprietario;
import br.com.restaurant_manager.restaurant_manager.application.usecases.cliente.ListarClientes;
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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class ListarProprietarioTest {

    @Mock
    private RepositorioDeProprietario repositorioDeProprietario;

    @InjectMocks
    private ListarProprietarios listarProprietarios;

    Proprietario proprietario1 = new Proprietario("José das Couves", "jose.couves@google.com",
            "jose.couves", "senha123",
            new Endereco("Rua dos Passarinhos", "999", "Casa", "Bairro Z", "Pirapora do Oeste", "PR", "12345678"),
            new TipoUsuario("Proprietario"));

    Proprietario proprietario2 = new Proprietario("Gerald de Rívia", "gerald.rivia@google.com",
            "gerald.rivia", "senha980",
            new Endereco("Rua dos Passarinhos", "1000", "Casa", "Bairro Z", "Pirapora do Oeste", "PR", "12345678"),
            new TipoUsuario("Proprietario"));

    List<Proprietario> proprietarios = List.of(proprietario1, proprietario2);

    @Test
    void deveListarProprietarios(){

        when(repositorioDeProprietario.listar()).thenReturn(proprietarios);

        List<Proprietario> result = listarProprietarios.listarTodosOsProprietarios();

        assertEquals(2, result.size());
        verify(repositorioDeProprietario).listar();
    }

}
