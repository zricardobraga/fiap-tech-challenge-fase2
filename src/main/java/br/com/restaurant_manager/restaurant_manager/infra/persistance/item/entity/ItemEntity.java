package br.com.restaurant_manager.restaurant_manager.infra.persistance.item.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "itens")
@Getter
@Setter
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private boolean disponibilidadeDePedirApenasNoRestaurante;
    private String fotoDoPrato;

    public ItemEntity() {
    }

    public ItemEntity(Long id, String nome, String descricao, Double preco, boolean disponibilidadeDePedirApenasNoRestaurante, String fotoDoPrato) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.disponibilidadeDePedirApenasNoRestaurante = disponibilidadeDePedirApenasNoRestaurante;
        this.fotoDoPrato = fotoDoPrato;
    }
}
