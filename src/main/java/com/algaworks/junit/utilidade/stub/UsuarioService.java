package com.algaworks.junit.utilidade.stub;

public class UsuarioService {

    private final RepositorioUsuario repo;

    public UsuarioService(RepositorioUsuario repo) {
        this.repo = repo;
    }

    public String obterEmail(Long id) {
        Usuario  usuario = repo.buscarPorId(id);
        if (usuario == null) {
            return null;
        }
        return usuario.getEmail();
    }
}
