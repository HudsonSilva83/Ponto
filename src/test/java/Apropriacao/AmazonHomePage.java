package Apropriacao;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonHomePage extends BasePage {

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

	public void clicarMenuLembretesAlarme() {
		clicarId("iTimersAndAlarms");

	}

	public void butonAdicionarLembretes() {
		clicar("a[class=\"standard-component image-text-nav\"]");

	}

	public void escreverlembrete(String string) {
		escreverCss("input[class=\"input input-edit\"]", string + Keys.TAB);

	}

	public void clicarHora() {

		clicar(By.xpath(".//section[@class=\"standard-component text-editable-date-time\"][2]/div[2]/div/button"));
		

	}

	public String pegarHora() {
		return obterValue(By.cssSelector("input[type=\"time\"]"));

	}

	public void setarHora(String hora) {
		escrever(By.cssSelector("input[type=\"time\"]"), hora);

	}

	public void clicarData() {

		javaClicarData01();
		// clicar(By.id("d-editable-text-Data"));

	}

	public void enterData() {

		enter(By.cssSelector("div[class=\"editable-date-region\"]"));

		// enter(By.cssSelector("input[type=\"date\"]"));

	}

	public void enterHora() {
		//enter(By.cssSelector("input[class=\"input input-edit\"]"));
         enter(By.cssSelector("input[type=\"time\"]"));
	}

	public void clicaComboselect() {
		clicar(By.xpath(".//section[@class=\"standard-component text-dropdown\"]/div[2]/div/select"));
		
	}

	public void select() {
		
		selectCombo(By.xpath(".//section[@class=\"standard-component text-dropdown\"]/div[2]/div/select"));
		
	}

	public void butonSalvar() {
		clicar(By.id("reminderSaveButton"));
		
	}

}
