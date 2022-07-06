package Apropriacao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.mail.EmailException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.jupiter.api.Test;

public class GoogleTest {

	private WebDriver driver;
	private BasePage base;
	private TangerinoApropriacaoHorasPage tangerinoApropriacaoPage;
	private TangerinoHomePage tangerinoHomePage;
	private ApropriacaoHomePage apropriacaoHomePage;
	private ApropriacaoPage apropriacaoPage;
	private AmazonHomePage amazonHomePage;

	// RODAR JENKINS A CADA 5 MINUTOS H/5 * * * *
	@BeforeEach
	public void inicializa() {

		// driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		ChromeOptions headless = new ChromeOptions();
		headless.addArguments("headless");
		driver = new ChromeDriver(headless);
		//driver = new ChromeDriver();

	}

	@Test
	public void Apropriar() throws InterruptedException, EmailException {

		driver.get("https://app.tangerino.com.br/Tangerino/pages/apropriacao-horas?funcionalidade=5&wicket:pageMapName=wicket-0");
		//System.out.println(driver.findElement(By.className("gNO89b")).getAttribute("Value"));
		
	}

	@AfterEach
	public void finalizar() {

		driver.quit();

	}
}