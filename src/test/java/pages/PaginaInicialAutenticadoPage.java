package pages;

import org.openqa.selenium.WebDriver;
import suporte.Instance;

import java.util.concurrent.TimeUnit;

public class PaginaInicialAutenticadoPage extends Instance {
    public PaginaInicialAutenticadoPage(WebDriver navegador){
        super(navegador);
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
