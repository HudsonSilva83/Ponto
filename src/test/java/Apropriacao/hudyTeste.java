package Apropriacao;



import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.l86400.component.selenium.core.web.driver.manager.WebDriverManager;



public class hudyTeste {



    public WebDriver driver;

    public String baseUrl = "https://www.google.com";  
   
    
   
    @Test           
   
    public void hudsonTestGoogle() {      
   
    	ChromeOptions options = new ChromeOptions();

    	 options.addArguments("--no-sandbox");
    	 options.addArguments("--disable-dev-shm-usage");
    	 options.addArguments("--headless");

    	 driver = new ChromeDriver(options);
   
    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);  
    driver.manage().window().maximize();  
    driver.get(baseUrl);
    
   
   
    driver.close();
    
    System.out.println("Aeee abriu a janela e fechou");
   
    }     



    
}
