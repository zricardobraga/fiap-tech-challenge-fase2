package br.com.restaurant_manager.restaurant_manager.model.entities.tipoUsuario;

public class TipoUsuario {
    private Long id;
    private String nomeDoTipo;

    public TipoUsuario() {
    }

    public TipoUsuario(String nomeDoTipo) {
        this.nomeDoTipo = nomeDoTipo;
    }

    public TipoUsuario(Long id, String nomeDoTipo) {
        this.id = id;
        this.nomeDoTipo = nomeDoTipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDoTipo() {
        return nomeDoTipo;
    }

    public void setNomeDoTipo(String nomeDoTipo) {
        this.nomeDoTipo = nomeDoTipo;
    }
}