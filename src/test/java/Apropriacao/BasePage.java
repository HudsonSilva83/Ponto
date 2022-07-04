package Apropriacao;


import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	private WebDriver driver;

	public BasePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void escrever(By by, String texto) {

		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(texto);

	}

	public void escrever(String id_campo, String texto) {
		
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id_campo)));

		escrever(By.id(id_campo), texto);

	}

	public void escreverCss(String css_campo, String texto) {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css_campo)));

		driver.findElement(By.cssSelector(css_campo)).sendKeys(texto);

	}

	public void clicarBotao(String css) {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css)));
		driver.findElement(By.cssSelector(css)).click();

	}

	public String obterValor(String id_campo) {

		return driver.findElement(By.id(id_campo)).getAttribute("value");

	}

	public String obterTexto(String css) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css)));

		return driver.findElement(By.cssSelector(css)).getText();

	}
	
	
	public String obterTexto(By by) {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated((by)));

		return driver.findElement(by).getText();

	}
	
	
	public String obterValue(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated((by)));

		return driver.findElement(by).getAttribute("value");

	}


	public String obterTitle(String css) {

		return driver.findElement(By.cssSelector(css)).getAttribute("title");

	}

	public String obterTitulo() {

		return driver.getTitle();

	}

	public void clicar(String x) {

		driver.findElement(By.cssSelector(x)).click();

	}
	
	public void clicar(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated((by)));

		driver.findElement(by).click();

	}
	
	public void clicar2(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated((by)));
		driver.findElement(by).click();

	}

	public void clicarId(String x) {

		driver.findElement(By.id(x)).click();

	}

	public void clicarCss(String x) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(x)));
				
		driver.findElement(By.cssSelector(x)).click();

	}

	public void acessarPagina(String url) {

		driver.get(url);

	}

	public void aumentarTela() {

		driver.manage().window().setSize(new Dimension(1200, 765));

	}

	public void clicarLink(String texto) {

		driver.findElement(By.linkText(texto)).click();

	}


	public void aba(int aba, String url) {

		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(aba));
		driver.get(url);

	}

	public void scrollar() {

		JavascriptExecutor jse3 = (JavascriptExecutor) driver;
		jse3.executeScript("scrollBy(0,1300)", "");

	}

	public void scrollar2() {

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scrollBy(0,350)", "");

	}
	
	
	
	
	public boolean ConteudoPagina(String pesquisa) {

		return driver.getPageSource().contains(pesquisa);

	}

	public void javaClicar() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.querySelector('input[type=\"checkbox\"]').click();");
		jse.executeScript("document.querySelector('button[class=\"edit-button\"]').click();");

	}

	public void javaClicar2() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.querySelector('button[class=\"edit-button\"]').click();");

	}
	
	public void limpar(By by) {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated((by)));
		driver.findElement(by).clear();
		
		
	}

}
