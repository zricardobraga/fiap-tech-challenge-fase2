package br.com.restaurant_manager.restaurant_manager.infra.gateways.Item;

import br.com.restaurant_manager.restaurant_manager.application.gateways.item.RepositorioDeItem;
import br.com.restaurant_manager.restaurant_manager.infra.exceptions.ResourceFoundException;
import br.com.restaurant_manager.restaurant_manager.infra.exceptions.ResourceNotFoundException;
import br.com.restaurant_manager.restaurant_manager.infra.persistance.item.entity.ItemEntity;
import br.com.restaurant_manager.restaurant_manager.infra.persistance.item.repository.ItemRepository;
import br.com.restaurant_manager.restaurant_manager.model.entities.item.Item;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeItemJPA implements RepositorioDeItem {

    private final ItemRepository itemRepository;
    private final ItemEntityMapper  itemEntityMapper;

    public RepositorioDeItemJPA(ItemRepository itemRepository, ItemEntityMapper itemEntityMapper) {
        this.itemRepository = itemRepository;
        this.itemEntityMapper = itemEntityMapper;
    }

    @Override
    public Item cadastrar(Item item) {
        this.itemRepository.findByNome(item.getNome()).ifPresent(i -> {
            throw new ResourceFoundException("Item já cadastrado");
        });
        ItemEntity itemEntity = this.itemEntityMapper.toEntity(item);
        this.itemRepository.save(itemEntity);
        return this.itemEntityMapper.toDomain(itemEntity);
    }

    @Override
    public List<Item> listar() {
        return this.itemRepository.findAll().stream().map(this.itemEntityMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Item buscarPorId(Long id) {
        return this.itemRepository.findById(id).map(item -> this.itemEntityMapper.toDomain(item)).orElseThrow(
                () -> new ResourceNotFoundException("Item não cadastrado"));
    }

    @Override
    public Item atualizar(Long id, Item item) {
        var itemASerAtualizado = this.itemRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Item não cadastrado"));

        itemASerAtualizado.setNome(item.getNome());
        itemASerAtualizado.setDescricao(item.getDescricao());
        itemASerAtualizado.setPreco(item.getPreco());
        itemASerAtualizado.setDisponibilidadeDePedirApenasNoRestaurante(item.isDisponibilidadeDePedirApenasNoRestaurante());
        itemASerAtualizado.setFotoDoPrato(item.getFotoDoPrato());

        this.itemRepository.save(itemASerAtualizado);
        return this.itemEntityMapper.toDomain(itemASerAtualizado);
    }

    @Override
    public void remover(Long id) {
        this.itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item não encontrado"));
        this.itemRepository.deleteById(id);
    }
}
