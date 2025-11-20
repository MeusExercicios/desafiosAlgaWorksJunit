package com.algaworks.junit.utilidade.stub;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//objetivo do stub testar um serviço sem usar valores reais, por exemplo de banco.
//cria uma classe que extende do repositório e trabalho o teste em cima dela.

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RepositorioUsuarioStubTest {

    @Test
    void deve_retornar_usuario_com_stub() {
        UsuarioService service = new UsuarioService(new RepositorioUsuarioStub());
        assertEquals("carlin@gmail.com",service.obterEmail(1L));
    }
}