package br.com.restaurant_manager.restaurant_manager.application.gateways.tipoUsuario;

import br.com.restaurant_manager.restaurant_manager.model.entities.tipoUsuario.TipoUsuario;

import java.util.List;

public interface RepositorioDeTipoUsuario {
    TipoUsuario cadastrar(TipoUsuario tipoUsuario);
    List<TipoUsuario> listar();
    TipoUsuario buscarPorId(Long id);
    TipoUsuario atualizar(Long id, TipoUsuario tipoUsuario);
    void remover(Long id);
}
