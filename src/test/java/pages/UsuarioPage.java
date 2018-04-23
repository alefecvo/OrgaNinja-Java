package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import suporte.Instance;

import java.util.concurrent.TimeUnit;

public class UsuarioPage extends Instance {
    public UsuarioPage(WebDriver navegador)
    {
        super(navegador);
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private UsuarioPage txtNome(String nome){
        navegador.findElement(By.name("registerName")).sendKeys(nome);
        return (this);
    }

    private UsuarioPage txtEmail(String email){
        navegador.findElement(By.name("registerEmail")).sendKeys(email);
        return (this);
    }

    private UsuarioPage txtSenha(String senha){
        navegador.findElement(By.name("registerPassword")).sendKeys(senha);
        return (this);
    }

    private PaginaInicialAutenticadoPage btnComecarUsar(){
        navegador.findElement(By.xpath("//button[text()='Começar a usar :)']")).click();
        return new PaginaInicialAutenticadoPage(navegador);
    }

    public PaginaInicialAutenticadoPage cadastrarUsuario(String nome, String email, String senha){
        txtNome(nome);
        txtEmail(email);
        txtSenha(senha);
        btnComecarUsar();
        return new PaginaInicialAutenticadoPage(navegador);
    }
}
