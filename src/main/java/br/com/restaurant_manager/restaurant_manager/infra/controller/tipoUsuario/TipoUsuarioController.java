package br.com.restaurant_manager.restaurant_manager.infra.controller.tipoUsuario;

import br.com.restaurant_manager.restaurant_manager.application.usecases.tipoUsuario.*;
import br.com.restaurant_manager.restaurant_manager.infra.controller.dtos.request.tipoUsuario.TipoUsuarioRequestDTO;
import br.com.restaurant_manager.restaurant_manager.infra.controller.dtos.response.tipoUsuario.TipoUsuarioResponseDTO;
import br.com.restaurant_manager.restaurant_manager.model.entities.tipoUsuario.TipoUsuario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("tiposUsuario")
@Tag(name= "Tipos de Usuários", description = "CRUD de Tipos de Usuários")
public class TipoUsuarioController {

    private static final Logger logger = LoggerFactory.getLogger(TipoUsuarioController.class);

    private final CadastrarTipoUsuario cadastrarTipoUsuario;
    private final ListarTiposUsuario listarTiposUsuario;
    private final BuscarTipoUsuarioPorId buscarTipoUsuarioPorId;
    private final AtualizarTipoUsuario atualizarTipoUsuario;
    private final RemoverTipoUsuario removerTipoUsuario;

    public TipoUsuarioController(CadastrarTipoUsuario cadastrarTipoUsuario, ListarTiposUsuario listarTiposUsuario, BuscarTipoUsuarioPorId buscarTipoUsuarioPorId, AtualizarTipoUsuario atualizarTipoUsuario, RemoverTipoUsuario removerTipoUsuario) {
        this.cadastrarTipoUsuario = cadastrarTipoUsuario;
        this.listarTiposUsuario = listarTiposUsuario;
        this.buscarTipoUsuarioPorId = buscarTipoUsuarioPorId;
        this.atualizarTipoUsuario = atualizarTipoUsuario;
        this.removerTipoUsuario = removerTipoUsuario;
    }

    @PostMapping
    @Operation(summary = "Cadastro de tipo de usuário", description = "Essa função é responsável por cadastrar um tipo de usuário")
    public ResponseEntity<Object> cadastrarTipoUsuario(@RequestBody TipoUsuarioRequestDTO tipoUsuarioDTO) {
        logger.info("POST -> /tiposUsuario");
        TipoUsuario tipoUsuarioASerCadastrado = cadastrarTipoUsuario.cadatrarTipoUsuario(new TipoUsuario(tipoUsuarioDTO.nomeDoTipo()));
        return ResponseEntity.ok(new TipoUsuarioResponseDTO(tipoUsuarioASerCadastrado.getId(), tipoUsuarioASerCadastrado.getNomeDoTipo()));
    }

    @GetMapping
    @Operation(summary = "Lista todos os tipos de usuário", description = "Essa função é responsável por listar todos os tipos de usuário cadastrados no sistema")
    public ResponseEntity<List<TipoUsuarioResponseDTO>> listarTiposUsurio() {
        logger.info("GET -> /tipos_usuario");
        return ResponseEntity.ok(listarTiposUsuario.listarTodosOsTiposUsuario()
                .stream()
                .map(tipoUsuario -> new TipoUsuarioResponseDTO(tipoUsuario.getId(), tipoUsuario.getNomeDoTipo()))
                .collect(Collectors.toList()));
    }

    @GetMapping("{id}")
    @Operation(summary = "Busca o tipo de usuário por Id", description = "Essa função é responsável por buscar um tipo de usuário informando o seu id")
    public ResponseEntity<Object> buscarTipoUsuarioPorId(@PathVariable("id")Long id) {
        logger.info("GET -> /tiposUsuario/{id}", id);
        var tipoUsuarioEncontrado = this.buscarTipoUsuarioPorId.buscarTipoUsuarioPorId(id);
        return ResponseEntity.ok(tipoUsuarioEncontrado);
    }

    @PutMapping("{id}")
    @Operation(summary = "Atualiza o tipo de usuário", description = "Essa função é responsável por atualizar um tipo de usuário informando o seu id")
    public ResponseEntity<Object> atualizarTipoUsuario(@PathVariable("id") Long id, @RequestBody TipoUsuarioRequestDTO tipoUsuarioRequestDTO) {
        logger.info("PUT -> /tiposUsuario/{id}", id);
        var tipoUsuarioASerAtualizado = this.atualizarTipoUsuario.atualizarTipoUsuario(id, new TipoUsuario(tipoUsuarioRequestDTO.nomeDoTipo()));
        return ResponseEntity.ok(tipoUsuarioASerAtualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove o tipo de usuário", description = "Essa função é responsável por remover um tipo de usuário informando o seu id")
    public ResponseEntity<String> removerTipoUsuario(@PathVariable("id") Long id){
        logger.info("DELETE -> /tiposUsuario/{id}", id);
        this.removerTipoUsuario.removerTipoUsuario(id);
        return ResponseEntity.noContent().build();
    }

}
