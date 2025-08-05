package br.com.restaurant_manager.restaurant_manager.application.usecases.tipoUsuario;

import br.com.restaurant_manager.restaurant_manager.application.gateways.tipoUsuario.RepositorioDeTipoUsuario;
import br.com.restaurant_manager.restaurant_manager.model.entities.tipoUsuario.TipoUsuario;

public class AtualizarTipoUsuario {

    private final RepositorioDeTipoUsuario repositorioDeTipoUsuario;

    public AtualizarTipoUsuario(RepositorioDeTipoUsuario repositorioDeTipoUsuario) {
        this.repositorioDeTipoUsuario = repositorioDeTipoUsuario;
    }

    public TipoUsuario atualizarTipoUsuario(Long id, TipoUsuario tipoUsuario) {
        return this.repositorioDeTipoUsuario.atualizar(id, tipoUsuario);
    }
}
