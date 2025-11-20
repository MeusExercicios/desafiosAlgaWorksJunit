package com.algaworks.junit.utilidade.stub;

public class RepositorioUsuarioStub extends RepositorioUsuario{

    @Override
    Usuario buscarPorId(Long id){
        return new Usuario(1L,"Carlin","carlin@gmail.com");
    }
}
