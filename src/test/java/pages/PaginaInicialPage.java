package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import suporte.Instance;

import java.util.concurrent.TimeUnit;

public class PaginaInicialPage extends Instance {

    public PaginaInicialPage(WebDriver navegador) {
        super(navegador);
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public LoginPage cliqueLogin() {
        navegador.findElement(By.linkText("LOGIN")).click();
        return new LoginPage (navegador);
    }
}


