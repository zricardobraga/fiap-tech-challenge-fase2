package br.com.restaurant_manager.restaurant_manager.model.entities.proprietario;

import br.com.restaurant_manager.restaurant_manager.model.Endereco;
import br.com.restaurant_manager.restaurant_manager.model.entities.tipoUsuario.TipoUsuario;

import java.util.Date;

public class Proprietario {
    private Long id;
    private String nome;
    private String email;
    private String login;
    private String senha;
    private Date ultimaAlteracao;
    private Endereco endereco;
    private TipoUsuario tipoUsuario;

    public Proprietario() {
    }

    public Proprietario(String nome, String email, String login, String senha, Endereco endereco, TipoUsuario tipoUsuario) {
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.endereco = endereco;
        this.tipoUsuario = tipoUsuario;
    }

    public Proprietario(Long id, String nome, String email, String login, String senha, Date ultimaAlteracao, Endereco endereco, TipoUsuario tipoUsuario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.ultimaAlteracao = ultimaAlteracao;
        this.endereco = endereco;
        this.tipoUsuario = tipoUsuario;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getUltimaAlteracao() {
        return ultimaAlteracao;
    }

    public void setUltimaAlteracao(Date ultimaAlteracao) {
        this.ultimaAlteracao = ultimaAlteracao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) { this.endereco = endereco; }

    public TipoUsuario getTipoUsuario() { return tipoUsuario; }

    public void setTipoUsuario(TipoUsuario tipoUsuario) { this.tipoUsuario = tipoUsuario; }
}
