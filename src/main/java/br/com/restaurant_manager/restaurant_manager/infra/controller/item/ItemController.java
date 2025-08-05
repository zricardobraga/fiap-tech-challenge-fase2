package br.com.restaurant_manager.restaurant_manager.infra.controller.item;

import br.com.restaurant_manager.restaurant_manager.application.usecases.item.*;
import br.com.restaurant_manager.restaurant_manager.infra.controller.dtos.request.item.ItemRequestDTO;
import br.com.restaurant_manager.restaurant_manager.infra.controller.dtos.response.item.ItemResponseDTO;
import br.com.restaurant_manager.restaurant_manager.model.entities.item.Item;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("itens")
@Tag(name= "Item", description = "CRUD de item")
public class ItemController {

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    private final CadastrarItem cadastrarItem;
    private final ListarItens listarItens;
    private final BuscarItemPorId buscarItemPorId;
    private final AtualizarItem atualizarItem;
    private final RemoverItem removerItem;

    public ItemController(CadastrarItem cadastrarItem, ListarItens listarItens, BuscarItemPorId buscarItemPorId, AtualizarItem atualizarItem, RemoverItem removerItem) {
        this.cadastrarItem = cadastrarItem;
        this.listarItens = listarItens;
        this.buscarItemPorId = buscarItemPorId;
        this.atualizarItem = atualizarItem;
        this.removerItem = removerItem;
    }

    @PostMapping
    @Operation(summary = "Cadastro de item", description = "Essa função é responsável por cadastrar um item que será vendido pelo restaurante")
    public ResponseEntity<Object> cadastrarItem(@RequestBody ItemRequestDTO itemRequestDTO) {
        logger.info("POST -> /itens");
        Item itemASerCadastrado = this.cadastrarItem.cadastrarItem(new Item(itemRequestDTO.nome(), itemRequestDTO.descricao(), itemRequestDTO.preco(),
                itemRequestDTO.disponibilidadeDePedirApenasNoRestaurante(), itemRequestDTO.fotoDoPrato()));
        return ResponseEntity.ok(new ItemResponseDTO(itemASerCadastrado.getId(), itemASerCadastrado.getNome(), itemASerCadastrado.getDescricao(),
                itemASerCadastrado.getPreco(), itemASerCadastrado.isDisponibilidadeDePedirApenasNoRestaurante(), itemASerCadastrado.getFotoDoPrato()));
    }

    @GetMapping
    @Operation(summary = "Lista todos os itens", description = "Essa função é responsável por listar todos os itens cadastrados no sistema")
    public ResponseEntity<List<ItemResponseDTO>> listarItens() {
        logger.info("GET -> /itens");
        return ResponseEntity.ok(this.listarItens.listarTodosOsItens()
                .stream()
                .map(item -> new ItemResponseDTO(item.getId(), item.getNome(), item.getDescricao(),
                        item.getPreco(), item.isDisponibilidadeDePedirApenasNoRestaurante(), item.getFotoDoPrato()))
                .collect(Collectors.toList()));
    }

    @GetMapping("{id}")
    @Operation(summary = "Busca o item por Id", description = "Essa função é responsável por buscar um item informando o seu id")
    public ResponseEntity<Object> buscarItemPorId(@PathVariable("id")Long id) {
        logger.info("GET -> /itens/{id}", id);
        var itemEncontrado = this.buscarItemPorId.buscarItemPorId(id);
        return ResponseEntity.ok(itemEncontrado);
    }

    @PutMapping("{id}")
    @Operation(summary = "Atualiza o item", description = "Essa função é responsável por atualizar um item informando o seu id")
    public ResponseEntity<Object> atualizarItem(@PathVariable("id") Long id, @RequestBody ItemRequestDTO itemRequestDTO) {
        logger.info("PUT -> /itens/{id}", id);
        var itemASerAtualizado = this.atualizarItem.atualizarItem(id, new Item(itemRequestDTO.nome(), itemRequestDTO.descricao(), itemRequestDTO.preco(),
                itemRequestDTO.disponibilidadeDePedirApenasNoRestaurante(), itemRequestDTO.fotoDoPrato()));
        return ResponseEntity.ok(itemASerAtualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove o item", description = "Essa função é responsável por remover um item informando o seu id")
    public ResponseEntity<String> removerItem(@PathVariable("id") Long id){
        logger.info("DELETE -> /itens/{id}", id);
        this.removerItem.removerItem(id);
        return ResponseEntity.noContent().build();
    }
}
