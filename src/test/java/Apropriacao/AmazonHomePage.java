package Apropriacao;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;



public class AmazonHomePage extends BasePage{
	
	private WebDriver driver;

	public AmazonHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void acessarPaginaAmazon(int valor, String url) {
		
		aba(valor, url);
		
	}

	public void autenticarAmazon() {
		
		
		escrever("ap_email", "hu.psilva@gmail.com");
		escrever("ap_password", "@Ira8383");
		clicarId("signInSubmit");
		
		
		
		
		
	}
	
		
	

}
