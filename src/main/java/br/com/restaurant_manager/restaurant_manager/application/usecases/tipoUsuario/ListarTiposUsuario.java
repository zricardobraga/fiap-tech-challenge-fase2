package br.com.restaurant_manager.restaurant_manager.application.usecases.tipoUsuario;

import br.com.restaurant_manager.restaurant_manager.application.gateways.tipoUsuario.RepositorioDeTipoUsuario;
import br.com.restaurant_manager.restaurant_manager.model.entities.tipoUsuario.TipoUsuario;

import java.util.List;

public class ListarTiposUsuario {
    private final RepositorioDeTipoUsuario repositorioDeTipoUsuario;

    public ListarTiposUsuario(RepositorioDeTipoUsuario repositorioDeTipoUsuario) {
        this.repositorioDeTipoUsuario = repositorioDeTipoUsuario;
    }

    public List<TipoUsuario> listarTodosOsTiposUsuario() {
        return this.repositorioDeTipoUsuario.listar();
    }
}
