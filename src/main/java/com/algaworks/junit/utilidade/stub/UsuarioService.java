package com.algaworks.junit.utilidade.stub;

public class UsuarioService {

    private final RepositorioUsuario repo;

    UsuarioService(RepositorioUsuario repo) {
        this.repo = repo;
    }

    String obterEmail(Long id) {
        return repo.buscarPorId(id).getEmail();
    }
}
