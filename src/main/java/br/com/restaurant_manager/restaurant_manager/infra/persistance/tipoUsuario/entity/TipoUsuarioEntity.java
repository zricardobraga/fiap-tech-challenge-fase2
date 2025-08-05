package br.com.restaurant_manager.restaurant_manager.infra.persistance.tipoUsuario.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tiposUsuario")
@Getter
@Setter
public class TipoUsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDoTipo;

    public TipoUsuarioEntity() {
    }

    public TipoUsuarioEntity(Long id, String nomeDoTipo) {
        this.id = id;
        this.nomeDoTipo = nomeDoTipo;
    }
}
