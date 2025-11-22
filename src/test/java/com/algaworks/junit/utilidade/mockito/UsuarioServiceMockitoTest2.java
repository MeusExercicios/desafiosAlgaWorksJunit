package com.algaworks.junit.utilidade.mockito;

import com.algaworks.junit.utilidade.stub.RepositorioUsuario;
import com.algaworks.junit.utilidade.stub.Usuario;
import com.algaworks.junit.utilidade.stub.UsuarioService;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class UsuarioServiceMockitoTest2 {

    @Mock
    RepositorioUsuario repoMock;

    @InjectMocks
    UsuarioService service;

    @Test
    void dado_id_quando_tiver_no_banco_entao_deve_retornar_o_email() {
        when(repoMock.buscarPorId(1L)).
                thenReturn(new Usuario(1L, "Carlin", "carlin@gmail.com"));

        String email = service.obterEmail(1L);

        assertEquals("carlin@gmail.com", email);

        verify(repoMock).buscarPorId(1L);

    }
}
