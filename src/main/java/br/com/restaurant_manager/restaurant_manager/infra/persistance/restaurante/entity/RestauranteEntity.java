package br.com.restaurant_manager.restaurant_manager.infra.persistance.restaurante.entity;

import br.com.restaurant_manager.restaurant_manager.infra.persistance.proprietario.entity.ProprietarioEntity;
import br.com.restaurant_manager.restaurant_manager.model.ENUM.HorarioDeFuncionamentoEnum;
import br.com.restaurant_manager.restaurant_manager.model.ENUM.TipoDeCozinhaEnum;
import br.com.restaurant_manager.restaurant_manager.model.Endereco;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "restaurantes")
@Getter
@Setter
public class RestauranteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Embedded
    private Endereco endereco;
    private TipoDeCozinhaEnum tipoDeCozinha;
    private HorarioDeFuncionamentoEnum horarioDeFuncionamento;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proprietario_id")
    private ProprietarioEntity donoDoRestaurante;

    public RestauranteEntity() {
    }

    public RestauranteEntity(Long id, String nome, Endereco endereco, TipoDeCozinhaEnum tipoDeCozinha, HorarioDeFuncionamentoEnum horarioDeFuncionamento, ProprietarioEntity donoDoRestaurante) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.tipoDeCozinha = tipoDeCozinha;
        this.horarioDeFuncionamento = horarioDeFuncionamento;
        this.donoDoRestaurante = donoDoRestaurante;
    }
}
