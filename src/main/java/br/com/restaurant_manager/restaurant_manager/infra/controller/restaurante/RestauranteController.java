package br.com.restaurant_manager.restaurant_manager.infra.controller.restaurante;

import br.com.restaurant_manager.restaurant_manager.application.usecases.restaurante.*;
import br.com.restaurant_manager.restaurant_manager.infra.controller.dtos.request.restaurante.RestauranteRequestDTO;
import br.com.restaurant_manager.restaurant_manager.infra.controller.dtos.response.proprietario.ProprietarioResponseDTO;
import br.com.restaurant_manager.restaurant_manager.infra.controller.dtos.response.restaurante.RestauranteResponseDTO;
import br.com.restaurant_manager.restaurant_manager.model.entities.proprietario.Proprietario;
import br.com.restaurant_manager.restaurant_manager.model.entities.restaurante.Restaurante;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("restaurantes")
@Tag(name= "Restaurante", description = "CRUD de restaurante")
public class RestauranteController {

    private static final Logger logger = LoggerFactory.getLogger(RestauranteController.class);

    private final AtualizarRestaurante atualizarRestaurante;
    private final BuscarRestaurantePorId buscarRestaurantePorId;
    private final CadastrarRestaurante cadastrarRestaurante;
    private final ListarRestaurantes listarRestaurantes;
    private final RemoverRestaurante removerRestaurante;

    public RestauranteController(AtualizarRestaurante atualizarRestaurante, BuscarRestaurantePorId buscarRestaurantePorId,
                                 CadastrarRestaurante cadastrarRestaurante, ListarRestaurantes listarRestaurantes, RemoverRestaurante removerRestaurante) {
        this.atualizarRestaurante = atualizarRestaurante;
        this.buscarRestaurantePorId = buscarRestaurantePorId;
        this.cadastrarRestaurante = cadastrarRestaurante;
        this.listarRestaurantes = listarRestaurantes;
        this.removerRestaurante = removerRestaurante;
    }

    @PostMapping
    @Operation(summary = "Cadastro de restaurante", description = "Essa função é responsável por cadastrar um restaurante")
    public ResponseEntity<Object> cadastrarRestaurante(@RequestBody RestauranteRequestDTO restauranteRequestDTO) {
        logger.info("POST -> /restaurantes");
        Proprietario donoDoRestaurante =  new Proprietario();
        donoDoRestaurante.setId(restauranteRequestDTO.proprietarioId());
        Restaurante restauranteASerCadastrado = cadastrarRestaurante.cadastrarRestaurante(
                new Restaurante(
                        restauranteRequestDTO.nome(),
                        restauranteRequestDTO.endereco(),
                        restauranteRequestDTO.tipoDeCozinha(),
                        restauranteRequestDTO.horarioDeFuncionamento(),
                        donoDoRestaurante
                ));

        return ResponseEntity.ok(
                new RestauranteResponseDTO(
                        restauranteASerCadastrado.getId(),
                        restauranteASerCadastrado.getNome(),
                        restauranteASerCadastrado.getEndereco(),
                        restauranteASerCadastrado.getTipoDeCozinha(),
                        restauranteASerCadastrado.getHorarioDeFuncionamento(),
                        new ProprietarioResponseDTO(
                                restauranteASerCadastrado.getDonoDoRestaurante().getId(),
                                restauranteASerCadastrado.getDonoDoRestaurante().getNome())));
    }

    @GetMapping
    @Operation(summary = "Lista todos os restaurantes", description = "Essa função é responsável por listar todos os restaurantes cadastrados no sistema")
    public ResponseEntity<List<RestauranteResponseDTO>> listarRestaurantes() {
        logger.info("GET -> /restaurantes");
        return ResponseEntity.ok(listarRestaurantes.listarTodosOsRestaurantes()
                .stream()
                .map(restaurante -> new RestauranteResponseDTO(
                        restaurante.getId(),
                        restaurante.getNome(),
                        restaurante.getEndereco(),
                        restaurante.getTipoDeCozinha(),
                        restaurante.getHorarioDeFuncionamento(),
                        new ProprietarioResponseDTO(
                                restaurante.getDonoDoRestaurante().getId(),
                                restaurante.getDonoDoRestaurante().getNome())))
                .collect(Collectors.toList()));
    }

    @GetMapping("{id}")
    @Operation(summary = "Busca o restaurante por Id", description = "Essa função é responsável por buscar um restaurante informando o seu id")
    public ResponseEntity<Object> buscarRestaurantePorId(@PathVariable("id")Long id) {
        logger.info("GET -> /restaurantes/{id}", id);
        var restauranteEncontrado = this.buscarRestaurantePorId.buscarRestaurantePorId(id);
        return ResponseEntity.ok(restauranteEncontrado);
    }

    @PutMapping("{id}")
    @Operation(summary = "Atualiza o restaurante", description = "Essa função é responsável por atualizar um restaurante informando o seu id")
    public ResponseEntity<Object> atualizarRestaurante(@PathVariable("id") Long id, @RequestBody RestauranteRequestDTO restauranteRequestDTO) {
        logger.info("PUT -> /restaurantes/{id}", id);
        Proprietario donoDoRestaurante =  new Proprietario();
        donoDoRestaurante.setId(restauranteRequestDTO.proprietarioId());
        var restauranteASerAtualizado = atualizarRestaurante.atualizarRestaurante(
                id, new Restaurante(
                restauranteRequestDTO.nome(),
                restauranteRequestDTO.endereco(),
                restauranteRequestDTO.tipoDeCozinha(),
                restauranteRequestDTO.horarioDeFuncionamento(),
                donoDoRestaurante));
        return ResponseEntity.ok(restauranteASerAtualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove o restaurante", description = "Essa função é responsável por remover um restaurante informando o seu id")
    public ResponseEntity<String> removerRestaurante(@PathVariable("id") Long id){
        logger.info("DELETE -> /restaurantes/{id}", id);
        this.removerRestaurante.removerRestaurante(id);
        return ResponseEntity.noContent().build();
    }

}
