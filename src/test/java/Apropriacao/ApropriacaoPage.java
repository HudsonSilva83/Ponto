package Apropriacao;

import java.util.ArrayList;

import javax.print.attribute.standard.Fidelity;
import javax.swing.text.AbstractDocument.AbstractElement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ApropriacaoPage extends BasePage {

	private WebDriver driver;

	public ApropriacaoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clicarComboCliente() {

		clicar(By.cssSelector("input[role=\"combobox\"]"));
		// clicar(By.id("a70f66f8c00c"));
	}

	public void clicarClienteAfya() {
		
		
		clicar(By.xpath("/html/body/app-root/app-apropriacao/div/div/div/div/form/div[1]/div[1]/ng-select/ng-dropdown-panel/div/div[2]/div[2]"));
		
//		WebElement element = driver.findElement(By.id("a7839088a5c7-0"));
//		Select combo = new Select(element);
//		combo.deselectByVisibleText("Afya");
//		
		
	}
	public void clicarMenuProjeto() {

		clicar(By.xpath("//*[@id=\"ngb-nav-0-panel\"]/div/div/form/div[1]/div[2]/ng-select/div/div/div[2]"));

	}

	public void selecionarProjetoAfya() {
		// TODO Auto-generated method stub
		
		clicar(By.xpath("/html/body/app-root/app-apropriacao/div/div/div/div/form/div[1]/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div[2]"));
		
	}

	
	
	public void clicarMenuTipoAtividade() {
		
		clicar(By.xpath("//*[@id=\"ngb-nav-0-panel\"]/div/div/form/div[1]/div[3]/ng-select/div"));
		
	}

	public void opcaoMontagemAmbiente() {
		clicar(By.xpath("/html/body/app-root/app-apropriacao/div/div/div/div/form/div[1]/div[3]/ng-select/ng-dropdown-panel/div/div[2]/div[2]"));
		
	}

	public void preencherAtividade(String atividade) {
		//WebElement campo =  driver.findElement(By.xpath("//*[@id=\"ngb-nav-0-panel\"]/div/div/form/div[1]/div[5]/textarea"));
		clicar(By.xpath("//*[@id=\"ngb-nav-0-panel\"]/div/div/form/div[1]/div[5]/textarea"));
		escrever(By.xpath("//*[@id=\"ngb-nav-0-panel\"]/div/div/form/div[1]/div[5]/textarea"), atividade);
		
		
	}

	public void preencherHoraInicio(String horaInicial) {
		escrever(By.xpath("//*[@id=\"ngb-nav-0-panel\"]/div/div/form/div[2]/div[2]/input"), horaInicial);
		
		
	}
	
	
	public void preencherHoraFinal(String horaFinal) {
		escrever(By.xpath("//*[@id=\"ngb-nav-0-panel\"]/div/div/form/div[2]/div[4]/input"), horaFinal);
		
		
	}

	public void botaoRegistrar() {
		clicar(By.xpath("//*[@id=\"ngb-nav-0-panel\"]/div/div/form/div[2]/div[5]/button/div"));
		
	}
}
