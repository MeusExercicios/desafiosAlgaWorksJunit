package com.algaworks.junit.utilidade.stub;

public class RepositorioUsuario {

    private Usuario usuario;

    public RepositorioUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public RepositorioUsuario() {
    }

    public Usuario buscarPorId(Long id) {

        if (usuario != null && usuario.getId().equals(id)) {
            return usuario;
        }
        return null;
    }
}
