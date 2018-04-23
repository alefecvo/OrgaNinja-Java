package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.PaginaInicialPage;
import suporte.Instance;

import static org.junit.Assert.assertEquals;

public class LoginTest {
    public WebDriver navegador;

    public static String mensagemInformarEmail = "Você precisa informar seu email.";
    public static String mensagemUsuarioNaoCadastrado = "Usuário não cadastrado.";
    public static String mensagemSenhaInvalida = "Senha inválida.";

    @Before
    public void iniciarExecucao(){
        navegador = Instance.createChrome();
    }

    @Test
    public void testValidarRealizarLoginCamposNaoPreenchidos(){
        String resposta = new PaginaInicialPage(navegador)
                .cliqueLogin()
                .realizarLogin("","")
                .captureToastMensagem();

        assertEquals(mensagemInformarEmail,resposta);
    }

    @Test
    public void testValidarRealizarLoginUsuarioSenhaCorreta(){
        String resposta = new PaginaInicialPage(navegador)
                .cliqueLogin()
                .realizarLogin("alefecardozo@hotmail.com","123456")
                .captureUsuarioLogado();

        assertEquals("Meu Plano",resposta);
    }

    @Test
    public void testValidarRealizarLoginUsuarioIncorreto(){
        String resposta = new PaginaInicialPage(navegador)
                .cliqueLogin()
                .realizarLogin("alefecardozo@hotmail.com.br","123456")
                .captureToastMensagem();

        assertEquals(mensagemUsuarioNaoCadastrado,resposta);
    }

    @Test
    public void testValidarRealizarLoginSenhaIncorreta(){
        String resposta = new PaginaInicialPage(navegador)
                .cliqueLogin()
                .realizarLogin("alefecardozo@hotmail.com","1234567")
                .captureToastMensagem();

        assertEquals(mensagemSenhaInvalida,resposta);
    }

    @Test
    public void testValidarRealizarLoginUsuarioESenhaIncorreta(){
        String resposta = new PaginaInicialPage(navegador)
                .cliqueLogin()
                .realizarLogin("alefecardozo@hotmail.com.br","1234567")
                .captureToastMensagem();
        assertEquals(mensagemUsuarioNaoCadastrado,resposta);
    }

    @Test
    public void testValidarRealizarLoginUsuarioOuSenhaIncorreta(){
        String resposta = new PaginaInicialPage(navegador)
                .cliqueLogin()
                .realizarLogin("alefecardozo@hotmail.com.br","123456")
                .captureToastMensagem();
        assertEquals(mensagemUsuarioNaoCadastrado,resposta);
    }



    @After
    public void finalizarExecucao(){
        navegador.quit();
    }
}
