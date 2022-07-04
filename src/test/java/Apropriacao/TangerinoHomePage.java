package Apropriacao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TangerinoHomePage extends BasePage {

	private WebDriver driver;

	public TangerinoHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void menuColaborador() {

		clicar2(By.xpath("//*[@id=\"id13\"]/fieldset/ul/li[2]/a"));

	}
	
	public void preencherCodigoColaborador(String codigo) {

		escrever(By.id("id16"), codigo);

	}

	public void preencherPinColaborador(String pin) {
		escrever(By.id("id1a"), pin);
		
	}

	public void botaoLogar() {
		clicar(By.className("btnLogin"));
		
	}
	
	
	public void scrollar() {
		
		
		scrollar2();
		
	}

}
