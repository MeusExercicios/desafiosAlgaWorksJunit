    package com.algaworks.junit.utilidade.mockito;

    import com.algaworks.junit.utilidade.stub.RepositorioUsuario;
    import com.algaworks.junit.utilidade.stub.Usuario;
    import com.algaworks.junit.utilidade.stub.UsuarioService;
    import org.junit.jupiter.api.DisplayNameGeneration;
    import org.junit.jupiter.api.DisplayNameGenerator;
    import org.junit.jupiter.api.Test;

    import static org.junit.jupiter.api.Assertions.assertEquals;
    import static org.mockito.Mockito.*;

    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    public class UsuarioServiceMockitoTest {

        @Test
        void dado_um_usuario_quando_receber_id_entao_retorne_email(){
            RepositorioUsuario repoMock = mock(RepositorioUsuario.class);

            when(repoMock.buscarPorId(1L)).thenReturn(new Usuario(1L,"Carlin","carlin@gmail.com"));
            when(repoMock.buscarPorId(2L)).thenThrow(new RuntimeException("Erro no banco"));

            UsuarioService service = new UsuarioService(repoMock);

            String email = service.obterEmail(1L);

            assertEquals("carlin@gmail.com",email);

            verify(repoMock).buscarPorId(1L);
        }


        @Test
        void deve_retornar_null_quando_o_usuario_nao_existir(){
            RepositorioUsuario repoMock = mock(RepositorioUsuario.class);
            when(repoMock.buscarPorId(999L)).thenReturn(null);
            UsuarioService service = new UsuarioService(repoMock);
            String email = service.obterEmail(999L);

            assertEquals(null,email);

            verify(repoMock).buscarPorId(999L);


        }
    }
