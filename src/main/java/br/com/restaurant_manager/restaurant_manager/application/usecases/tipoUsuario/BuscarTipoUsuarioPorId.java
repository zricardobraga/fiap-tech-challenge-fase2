package br.com.restaurant_manager.restaurant_manager.application.usecases.tipoUsuario;

import br.com.restaurant_manager.restaurant_manager.application.gateways.tipoUsuario.RepositorioDeTipoUsuario;
import br.com.restaurant_manager.restaurant_manager.model.entities.tipoUsuario.TipoUsuario;

import java.util.Optional;

public class BuscarTipoUsuarioPorId {
    private final RepositorioDeTipoUsuario repositorioDeTipoUsuario;

    public BuscarTipoUsuarioPorId(RepositorioDeTipoUsuario repositorioDeTipoUsuario) {
        this.repositorioDeTipoUsuario = repositorioDeTipoUsuario;
    }

    public TipoUsuario buscarTipoUsuarioPorId(Long id){
        return this.repositorioDeTipoUsuario.buscarPorId(id);
    }
}
