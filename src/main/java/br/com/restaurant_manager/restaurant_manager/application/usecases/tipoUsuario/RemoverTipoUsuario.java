package br.com.restaurant_manager.restaurant_manager.application.usecases.tipoUsuario;

import br.com.restaurant_manager.restaurant_manager.application.gateways.tipoUsuario.RepositorioDeTipoUsuario;

public class RemoverTipoUsuario {

    private final RepositorioDeTipoUsuario repositorioDeTipoUsuario;

    public RemoverTipoUsuario(RepositorioDeTipoUsuario repositorioDeTipoUsuario) {
        this.repositorioDeTipoUsuario = repositorioDeTipoUsuario;
    }

    public void removerTipoUsuario(Long id) {
        this.repositorioDeTipoUsuario.remover(id);
    }
}
