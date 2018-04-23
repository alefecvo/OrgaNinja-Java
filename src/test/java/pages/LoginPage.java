package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import suporte.Instance;

import java.util.concurrent.TimeUnit;

public class LoginPage extends Instance {
    public LoginPage(WebDriver navegador){
        super(navegador);
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private LoginPage txtEmail(String email){
        navegador.findElement(By.name("loginEmail")).sendKeys(email);
        return (this);
    }

    private LoginPage txtSenha(String senha){
        navegador.findElement(By.name("loginPassword")).sendKeys(senha);
        return (this);
    }

    private PaginaInicialAutenticadoPage btnEntrar(){
        navegador.findElement(By.xpath("//button[text()='Entrar']")).click();
        return new PaginaInicialAutenticadoPage(navegador);
    }

    private PaginaInicialAutenticadoPage btnNovoCadastro(){
        navegador.findElement(By.xpath("//a[text()='Começe agora mesmo']")).click();
        return new PaginaInicialAutenticadoPage(navegador);
    }




    public PaginaInicialAutenticadoPage realizarLogin(String email, String senha){
        txtEmail(email);
        txtSenha(senha);
        btnEntrar();
        return new PaginaInicialAutenticadoPage(navegador);
    }

    public UsuarioPage cliqueNovoCadastro(){
        btnNovoCadastro();
        return new UsuarioPage(navegador);
    }
}
