package Apropriacao;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class ApropriacaoHomePage extends BasePage{
	
	
	private WebDriver driver;

	public ApropriacaoHomePage(WebDriver driver) {
		super(driver);
		
		
	}
	
	public void acessarPaginaApropriacao(int valor, String url) {
		
		aba(valor, url);
		
	}
	
	
	
	public void acessarPaginaAmazon(int valor, String url) {
		
		aba(valor, url);
		
	}

	public void butonGoogle() {
		
		
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > app-root > app-login > div > div > form > div:nth-child(1) > button")));
		clicar(By.cssSelector("body > app-root > app-login > div > div > form > div:nth-child(1) > button"));
		
	}
	
	
	public void preencherEmail() {
		
		clicar(By.id("identifierId"));
		escrever(By.id("identifierId"), "hudsonsilva@frwk.com.br");
		//escrever(By.xpath("//input[@id='identifierId']"), "hudsonsilva@frwk.com.br");
		
		
	}

	public void butonProximoGoogle() {
		
	
		
		clicar(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));
		
	} 
	
	public void butonProximoGoogle2() {
		clicar(By.xpath("//*[@id=\"passwordNext\"]/div/button/span"));
		
	}
	
	
	
	
	public void preencher() {
		escrever(By.name("password"),"Hpereira7");
		
	}
	
	public void scrollar() {
		
		scrollar2();
		
	}
	
	
	
	

}
