package br.com.restaurant_manager.restaurant_manager.model.entities.item;

public class Item {
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private boolean disponibilidadeDePedirApenasNoRestaurante;
    private String fotoDoPrato;

    public Item() {
    }

    public Item(String nome, String descricao, Double preco, boolean disponibilidadeDePedirApenasNoRestaurante, String fotoDoPrato) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.disponibilidadeDePedirApenasNoRestaurante = disponibilidadeDePedirApenasNoRestaurante;
        this.fotoDoPrato = fotoDoPrato;
    }

    public Item(Long id, String nome, String descricao, Double preco, boolean disponibilidadeDePedirApenasNoRestaurante, String fotoDoPrato) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.disponibilidadeDePedirApenasNoRestaurante = disponibilidadeDePedirApenasNoRestaurante;
        this.fotoDoPrato = fotoDoPrato;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public boolean isDisponibilidadeDePedirApenasNoRestaurante() {
        return disponibilidadeDePedirApenasNoRestaurante;
    }

    public void setDisponibilidadeDePedirApenasNoRestaurante(boolean disponibilidadeDePedirApenasNoRestaurante) {
        this.disponibilidadeDePedirApenasNoRestaurante = disponibilidadeDePedirApenasNoRestaurante;
    }

    public String getFotoDoPrato() {
        return fotoDoPrato;
    }

    public void setFotoDoPrato(String fotoDoPrato) {
        this.fotoDoPrato = fotoDoPrato;
    }
}
