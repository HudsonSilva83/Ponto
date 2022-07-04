package Apropriacao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Apropriacao.*;

public class TangerinoApropriacaoHorasPage extends BasePage {

	private WebDriver driver;

	public TangerinoApropriacaoHorasPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void menuColaboradores() {

		clicar(By.id("id23"));

	}

	public void subMenuApropriacaoHoras() {

		clicar(By.cssSelector("span[class='funcionalidade5']"));

	}

	public void preencherDataInicial(String dataInicial) {

		limpar(By.id("id3c"));
		escrever(By.id("id3c"), dataInicial);

	}

	public void preencherDataFinal(String dataInicial) {

		limpar(By.id("id3d"));
		escrever(By.id("id3d"), dataInicial);

	}



	public String obterHoraInicialEntrada() {
		return obterValue(By.cssSelector("input[class=\"entrada\"]"));

	}



	public String obterHoraSaidaAlmoco() {
		return obterValue(By.cssSelector("input[class=\"saida\"]"));

	}



	public String obterHoraEntradaVolta() {
		return obterValue(By.xpath(".//*/tbody/tr[3]/td[3]/input[1]"));

	}



	public String obterHoraSaidaTrabalho() {
		return obterValue(By.xpath(".//*/tbody/tr[3]/td[3]/input[2]"));

	}

	public void butonCosultar() {
		clicar(By.id("id5d"));

	}

}
