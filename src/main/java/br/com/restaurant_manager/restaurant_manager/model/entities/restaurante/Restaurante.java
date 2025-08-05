package br.com.restaurant_manager.restaurant_manager.model.entities.restaurante;

import br.com.restaurant_manager.restaurant_manager.model.ENUM.HorarioDeFuncionamentoEnum;
import br.com.restaurant_manager.restaurant_manager.model.ENUM.TipoDeCozinhaEnum;
import br.com.restaurant_manager.restaurant_manager.model.Endereco;
import br.com.restaurant_manager.restaurant_manager.model.entities.proprietario.Proprietario;

public class Restaurante {
    private Long id;
    private String nome;
    private Endereco endereco;
    private TipoDeCozinhaEnum tipoDeCozinha;
    private HorarioDeFuncionamentoEnum horarioDeFuncionamento;
    private Proprietario donoDoRestaurante;

    public Restaurante() {
    }

    public Restaurante(String nome, Endereco endereco, TipoDeCozinhaEnum tipoDeCozinha, HorarioDeFuncionamentoEnum horarioDeFuncionamento, Proprietario donoDoRestaurante) {
        this.nome = nome;
        this.endereco = endereco;
        this.tipoDeCozinha = tipoDeCozinha;
        this.horarioDeFuncionamento = horarioDeFuncionamento;
        this.donoDoRestaurante = donoDoRestaurante;
    }

    public Restaurante(Long id, String nome, Endereco endereco, TipoDeCozinhaEnum tipoDeCozinha, HorarioDeFuncionamentoEnum horarioDeFuncionamento, Proprietario donoDoRestaurante) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.tipoDeCozinha = tipoDeCozinha;
        this.horarioDeFuncionamento = horarioDeFuncionamento;
        this.donoDoRestaurante = donoDoRestaurante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public TipoDeCozinhaEnum getTipoDeCozinha() {
        return tipoDeCozinha;
    }

    public void setTipoDeCozinha(TipoDeCozinhaEnum tipoDeCozinha) {
        this.tipoDeCozinha = tipoDeCozinha;
    }

    public HorarioDeFuncionamentoEnum getHorarioDeFuncionamento() {
        return horarioDeFuncionamento;
    }

    public void setHorarioDeFuncionamento(HorarioDeFuncionamentoEnum horarioDeFuncionamento) {
        this.horarioDeFuncionamento = horarioDeFuncionamento;
    }

    public Proprietario getDonoDoRestaurante() {
        return donoDoRestaurante;
    }

    public void setDonoDoRestaurante(Proprietario donoDoRestaurante) {
        this.donoDoRestaurante = donoDoRestaurante;
    }
}
