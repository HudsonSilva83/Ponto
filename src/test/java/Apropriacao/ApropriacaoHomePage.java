package Apropriacao;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;



public class ApropriacaoHomePage extends BasePage{
	
	private WebDriver driver;

	public ApropriacaoHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void acessarPaginaApropriacao(int valor, String url) {
		
		aba(valor, url);
		
	}
	
	
	
	public void acessarPaginaAmazon(int valor, String url) {
		
		aba(valor, url);
		
	}

	public void butonGoogle() {
		clicar(By.cssSelector("body > app-root > app-login > div > div > form > div:nth-child(1) > button"));
		
	}
	
	
	public void preencherEmail() {
		
		
		escrever(By.id("identifierId"), "hudsonsilva@frwk.com.br");
		
		
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
