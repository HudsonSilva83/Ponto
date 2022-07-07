package Apropriacao;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.mail.EmailException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ApropTestet {

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


		//driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		driver = new ChromeDriver(options);
		
		 
		//System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		//driver = new FirefoxDriver();
	       
	     
//		

		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		
		
		
		//System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
	     //driver = new FirefoxDriver();
		

	     //driver = new FirefoxDriver();
		//System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
		
	
		
		//driver = new ChromeDriver();
		
		//driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		// System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		 //System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");


		base = new BasePage(driver);
		tangerinoApropriacaoPage = new TangerinoApropriacaoHorasPage(driver);
		tangerinoHomePage = new TangerinoHomePage(driver);
		apropriacaoHomePage = new ApropriacaoHomePage(driver);
		apropriacaoPage = new ApropriacaoPage(driver);
		amazonHomePage = new AmazonHomePage(driver);

		base.aumentarTela();
		base.acessarPagina(
				"https://app.tangerino.com.br/Tangerino/pages/apropriacao-horas?funcionalidade=5&wicket:pageMapName=wicket-0");
		// base.acessarPagina("https://amazon.com.br");
		driver.manage().timeouts().implicitlyWait(190, TimeUnit.SECONDS);
		// driver.get();

		// baixar:
		// https://chromedriver.storage.googleapis.com/index.html?path=96.0.4664.45/
		// File file = new File("D:\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

	}

	@Test
	public void Apropriar() throws InterruptedException, EmailException {

		Thread.sleep(2000);
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
		base.scrollar2();
		Thread.sleep(2000);
		
		Date dataHoraAtual = new Date();
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
		String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);

		tangerinoApropriacaoPage.preencherDataInicial(data);
		Thread.sleep(2000);
		tangerinoApropriacaoPage.preencherDataFinal(data);
		tangerinoApropriacaoPage.butonCosultar();
		Thread.sleep(2000);

		// esperar voltar o servidor

		String horaEntradaTrabalho = (tangerinoApropriacaoPage.obterHoraInicialEntrada());
		String horaSaidaAlmoco = (tangerinoApropriacaoPage.obterHoraSaidaAlmoco());
				
		String horaEntradaVolta = (tangerinoApropriacaoPage.obterHoraEntradaVolta());
		String horaSaidaTrabalho = (tangerinoApropriacaoPage.obterHoraSaidaTrabalho());
//		System.out.println(horaEntradaVolta);
//		System.out.println(horaSaidaTrabalho);

		// ____________________________________________________________________//
		// mudar de aba para a aplicacao apropriacao

		apropriacaoHomePage.acessarPaginaApropriacao(1,"https://app.frwkapp.com.br/apropriacao");
		apropriacaoHomePage.butonGoogle();
		Thread.sleep(3000);
		
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[2]);
				
		apropriacaoHomePage.preencherEmail();
		apropriacaoHomePage.butonProximoGoogle();
		apropriacaoHomePage.preencher();
		apropriacaoHomePage.butonProximoGoogle2();
		
		Thread.sleep(5000);
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
		
		Thread.sleep(5000);
		
		apropriacaoHomePage.scrollar();
		Thread.sleep(2000);
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
		apropriacaoPage.preencherHoraInicio(horaEntradaTrabalho);
		Thread.sleep(500);
		apropriacaoPage.preencherHoraFinal(horaSaidaAlmoco);
		
		Thread.sleep(1000);
		apropriacaoPage.botaoRegistrar();
		Thread.sleep(3000);
		String mensagem = (apropriacaoPage.obterTexto(By.xpath("/html/body/app-root/app-toast-notification/div/div")));
		
		
//		//___________________________________________________
		
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
//
//		// Apropriação criada com sucesso.//mudei
//
//		NotificarPorEmailTest enviarEmail = new NotificarPorEmailTest();
//		enviarEmail.EnviarEmail("Pontos registrados  "+ mensagem);
		

		// horas configurar jenkins
		// https://stackoverflow.com/questions/12472645/how-do-i-schedule-jobs-in-jenkins?answertab=trending#tab-top

		amazonHomePage.acessarPaginaAmazon(1, "https://alexa.amazon.com.br/");
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
		amazonHomePage.setarHora("18:46");
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