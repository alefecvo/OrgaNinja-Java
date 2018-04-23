package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.PaginaInicialPage;
import suporte.Instance;

import static org.junit.Assert.assertEquals;

public class UsuarioTest {
    public WebDriver navegador;
    public static String mensagemUsuarioExistente= "Já existe um usuário cadastrado com o email informado.";
    public static String mensagemNomeNaoPreenchido = "Você precisa informar seu nome completo.";
    public static String mensagemEmailNaoPreenchido = "Você precisa informar seu email.";
    public static String mensagemSenhaNaoPreenchido = "Você precisa informar uma senha.";

    @Before
    public void iniciarExecucao(){
        navegador = Instance.createChrome();
    }

    @Test
    public void testValidarRealizarCadastroNovoUsuario(){
        String resposta = new PaginaInicialPage(navegador)
                .cliqueLogin()
                .cliqueNovoCadastro()
                .cadastrarUsuario("Álefe xx","alefecardozo@hotmail.com.xx","123456")
                .captureUsuarioLogado();

        assertEquals("Meu Plano",resposta);
    }

    @Test
    public void testValidarRealizarCadastroUsuarioExistente(){
        String resposta = new PaginaInicialPage(navegador)
                .cliqueLogin()
                .cliqueNovoCadastro()
                .cadastrarUsuario("Álefe","alefecardozo@hotmail.com","123456")
                .captureToastMensagem();

        assertEquals(mensagemUsuarioExistente,resposta);
    }

    @Test
    public void testValidarCamposObrigatoriosNomeNaoPreenchidos(){
        String respostaNomeNaoPreenchido = new PaginaInicialPage(navegador)
                .cliqueLogin()
                .cliqueNovoCadastro()
                .cadastrarUsuario("","alefecardozo@hotmai.com","123456")
                .captureToastMensagem();

        assertEquals(mensagemNomeNaoPreenchido,respostaNomeNaoPreenchido);
    }

    @Test
    public void testValidarRealizarCamposObrigatoriosEmailNaoPreenchidos(){
        String respostaEmailNaoPreenchido = new PaginaInicialPage(navegador)
                .cliqueLogin()
                .cliqueNovoCadastro()
                .cadastrarUsuario("Álefe","","123456")
                .captureToastMensagem();

        assertEquals(mensagemEmailNaoPreenchido,respostaEmailNaoPreenchido);
    }

    @Test
    public void testValidarRealizarCamposObrigatoriosSenhaNaoPreenchidos(){
        String respostaSenhaNaoPreenchida = new PaginaInicialPage(navegador)
                .cliqueLogin()
                .cliqueNovoCadastro()
                .cadastrarUsuario("Álefe","alefecardozo@hotmai.com","")
                .captureToastMensagem();

        assertEquals(mensagemSenhaNaoPreenchido,respostaSenhaNaoPreenchida);
    }

    @After
    public void finalizarExecucao(){
        navegador.quit();
    }
}
