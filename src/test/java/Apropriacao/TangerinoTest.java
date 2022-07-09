package Apropriacao;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.mail.EmailException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Test;

public class TangerinoTest {

	public WebDriver driver;
	private BasePage base;
	private TangerinoApropriacaoHorasPage tangerinoApropriacaoPage;
	private TangerinoHomePage tangerinoHomePage;
	private ApropriacaoHomePage apropriacaoHomePage;
	private ApropriacaoPage apropriacaoPage;
	private AmazonHomePage amazonHomePage;

	// RODAR JENKINS A CADA 5 MINUTOS H/5 * * * *
	@BeforeEach
	public void inicializa() {

		// System.setProperty("webdriver.chrome.driver",
		// "local/do/chromedriver/no/SISTEMA");

		// System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--headless");
		options.addArguments("--window-size=1200,800");
		options.addArguments("-user-agent=\"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36\"");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

//		options.addArguments("disable-popup-blocking");	
//		options.addArguments("--start-maximized");
//		options.addArguments("disable-infobars");
//		options.addArguments("--disable-extensions");
//		options.addArguments("--headless");
//		options.addArguments("-disable-gpu");

		// driver = new ChromeDriver();

		// driver = new FirefoxDriver();
		// System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");

		// FirefoxOptions options = new FirefoxOptions();
		// options.addArguments("--headless");
		// driver = new FirefoxDriver(options);
		// driver = new FirefoxDriver();

	}

	@Test
	public void AbrirTagerino() throws InterruptedException, EmailException {

		driver.get(
				"https://app.tangerino.com.br/Tangerino/pages/apropriacao-horas?funcionalidade=5&wicket:pageMapName=wicket-0");

		base = new BasePage(driver);
		tangerinoApropriacaoPage = new TangerinoApropriacaoHorasPage(driver);
		tangerinoHomePage = new TangerinoHomePage(driver);
		apropriacaoHomePage = new ApropriacaoHomePage(driver);
		apropriacaoPage = new ApropriacaoPage(driver);
		amazonHomePage = new AmazonHomePage(driver);

		Thread.sleep(1000);
        tangerinoHomePage.scrollar();
		
		tangerinoHomePage.menuColaborador();
		Thread.sleep(1000);
		
		
		tangerinoHomePage.preencherCodigoColaborador("3N11P");
		tangerinoHomePage.preencherPinColaborador("1000");
		tangerinoHomePage.botaoLogar();
		
		Thread.sleep(3000);
		tangerinoApropriacaoPage.menuColaboradores();
		
		Thread.sleep(2000);
		
		tangerinoApropriacaoPage.subMenuApropriacaoHoras();
		
		Thread.sleep(3000);
		tangerinoHomePage.scrollar();
		Thread.sleep(2000);
		
		Date dataHoraAtual = new Date();
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
		String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
//
//		
//		
		tangerinoApropriacaoPage.preencherDataInicial(data);
		Thread.sleep(3000);
		
		
		
		tangerinoApropriacaoPage.preencherDataFinal(data);
		Thread.sleep(2000);
		tangerinoApropriacaoPage.butonCosultar();
		Thread.sleep(2000);
//
//		// esperar voltar o servidor
//
//		// ate aqui ok
//
		 String horaEntradaTrabalho =(tangerinoApropriacaoPage.obterHoraInicialEntrada());
		 String horaSaidaAlmoco = (tangerinoApropriacaoPage.obterHoraSaidaAlmoco());
				
		String horaEntradaVolta = (tangerinoApropriacaoPage.obterHoraEntradaVolta());
	    String horaSaidaTrabalho = (tangerinoApropriacaoPage.obterHoraSaidaTrabalho());

		System.out.println("Entrada " + horaEntradaTrabalho);
		System.out.println("Saida " + horaSaidaAlmoco);
		System.out.println(horaEntradaVolta);
		System.out.println(horaSaidaTrabalho);

		// ----------------Apropriacao -------------------------

		apropriacaoHomePage.acessarPaginaApropriacao(1, "https://app.frwkapp.com.br/apropriacao");

		Thread.sleep(2000);

		apropriacaoHomePage.butonGoogle();
		Thread.sleep(3000);

		driver.switchTo().window((String) driver.getWindowHandles().toArray()[2]);
		Thread.sleep(3000);
		driver.manage().window().maximize();

		Thread.sleep(2000);
		apropriacaoHomePage.preencherEmail();
		Thread.sleep(2000);
		apropriacaoHomePage.butonProximoGoogle();
		Thread.sleep(3000);
		//apropriacaoHomePage.preencher();
		
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("@AnnaIra83");
		apropriacaoHomePage.butonProximoGoogle2();

		Thread.sleep(5000);
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);

		Thread.sleep(5000);

		apropriacaoHomePage.scrollar();
		
	
		Thread.sleep(4000);
		//apropriacaoPage.clicarComboCliente();
		driver.findElement(By.xpath("//*[@id=\"ngb-nav-0-panel\"]/div/div/form/div[1]/div[1]/ng-select")).click();
		Thread.sleep(4000);
		apropriacaoPage.clicarClienteAfya();
		Thread.sleep(3000);
		apropriacaoPage.clicarMenuProjeto();
		Thread.sleep(1000);
		apropriacaoPage.selecionarProjetoAfya();
		apropriacaoPage.clicarMenuTipoAtividade();
		Thread.sleep(1000);
		apropriacaoPage.opcaoMontagemAmbiente();
		apropriacaoPage.preencherAtividade("Automação app Conecta - Funcionalidade: Exame Admissional");
		apropriacaoPage.preencherHoraInicio(horaEntradaTrabalho);

		Thread.sleep(500);
		apropriacaoPage.preencherHoraFinal(horaSaidaAlmoco);
		

		Thread.sleep(1000);
		apropriacaoPage.botaoRegistrar();
		Thread.sleep(3000);
		String mensagem = (apropriacaoPage.obterTexto(By.xpath("/html/body/app-root/app-toast-notification/div/div")));

		apropriacaoPage.clicarComboCliente();
		Thread.sleep(2000);
		apropriacaoPage.clicarClienteAfya();
		Thread.sleep(3000);
		apropriacaoPage.clicarMenuProjeto();
		Thread.sleep(1000);
		apropriacaoPage.selecionarProjetoAfya();
		apropriacaoPage.clicarMenuTipoAtividade();
		Thread.sleep(1000);
		apropriacaoPage.opcaoMontagemAmbiente();
		apropriacaoPage.preencherAtividade("Automação app Conecta - Funcionalidade: Exame Admissional");
		apropriacaoPage.preencherHoraInicio(horaEntradaVolta);
		Thread.sleep(500);
		apropriacaoPage.preencherHoraFinal(horaSaidaTrabalho);
		
		Thread.sleep(1000);
		apropriacaoPage.botaoRegistrar();
		Thread.sleep(3000);
		String mensagemSegundo = (apropriacaoPage.obterTexto(By.xpath("/html/body/app-root/app-toast-notification/div/div")));

		
//		 Apropriação criada com sucesso.//mudei
//
		NotificarPorEmailTest enviarEmail = new NotificarPorEmailTest();
		enviarEmail.EnviarEmail("Pontos registrados  "+ mensagem);
		

		// horas configurar jenkins
		// https://stackoverflow.com/questions/12472645/how-do-i-schedule-jobs-in-jenkins?answertab=trending#tab-top

		amazonHomePage.acessarPaginaAmazon(2, "https://alexa.amazon.com.br/");
		amazonHomePage.autenticarAmazon();
		Thread.sleep(7000);
		amazonHomePage.clicarMenuLembretesAlarme();
		Thread.sleep(1000);
		amazonHomePage.butonAdicionarLembretes();
		amazonHomePage.escreverlembrete("Oi Hudson Hoje o seu ponto foi registrado com sucesso com a seguinte mensagem "+ mensagem);
		amazonHomePage.clicarData();
		// Thread.sleep(3000);
		// amazonHomePage.enterData();
		Thread.sleep(3000);

		amazonHomePage.clicarHora();
		Thread.sleep(1000);
		amazonHomePage.clicarHora();
		Thread.sleep(500);
		
		
		dataHoraAtual.setMinutes(dataHoraAtual.getMinutes() + 5);
		String horaA = new SimpleDateFormat("HH:mm").format(dataHoraAtual);
		System.out.println("Aqui está a hora" + horaA);
		
	
		amazonHomePage.setarHora(hora);
		Thread.sleep(500);
		amazonHomePage.enterHora();
		Thread.sleep(500);
		amazonHomePage.clicaComboselect();
		Thread.sleep(500);
		amazonHomePage.select();
		Thread.sleep(1000);
		amazonHomePage.butonSalvar();


	}

	@AfterEach
	public void finalizar() {

		driver.quit();

	}
}