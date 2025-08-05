package br.com.restaurant_manager.restaurant_manager.application.usecases.tipoUsuario;

import br.com.restaurant_manager.restaurant_manager.application.gateways.tipoUsuario.RepositorioDeTipoUsuario;
import br.com.restaurant_manager.restaurant_manager.model.entities.tipoUsuario.TipoUsuario;

public class CadastrarTipoUsuario {
    private RepositorioDeTipoUsuario repositorioDeTipoUsuario;

    public CadastrarTipoUsuario(RepositorioDeTipoUsuario repositorioDeTipoUsuario) {
        this.repositorioDeTipoUsuario = repositorioDeTipoUsuario;
    }

    public TipoUsuario cadatrarTipoUsuario(TipoUsuario tipoUsuario) {
        return this.repositorioDeTipoUsuario.cadastrar(tipoUsuario);
    }
}
