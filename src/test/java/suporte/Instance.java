package suporte;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Instance {
    public WebDriver navegador;

    public Instance(WebDriver navegador){
        this.navegador = navegador;
    }

    public static WebDriver createChrome(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Álefe\\IdeaProjects\\OrgaNinja-Java\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();

        navegador.get("http://organinja.herokuapp.com/");
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return navegador;
    }

    public String captureToastMensagem(){
        return navegador.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div[3]")).getText();
    }

    public String captureUsuarioLogado(){
        return navegador.findElement(By.xpath("//h5[text()='Meu Plano']")).getText();
    }


}
