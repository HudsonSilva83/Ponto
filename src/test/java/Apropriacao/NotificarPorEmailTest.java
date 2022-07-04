package Apropriacao;

import org.apache.commons.mail.DefaultAuthenticator;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;




public class NotificarPorEmailTest {

	//@ParameterizedTest
	//@MethodSource("NotificarPorEmailTest")
		public void EnviarEmail(String motivo) throws EmailException  {

		System.out.println("-----Enviando email----");
		
//		
//		Email email = new SimpleEmail();
//		email.setHostName("smtp.gmail.com");
//		email.setSmtpPort(465);
//		email.setAuthenticator(new DefaultAuthenticator("t800.hma@gmail.com", "hpereira6611"));
//		
//		email.setSSLOnConnect(true);
//		email.setFrom("t800.hma@gmail.com");
//		email.setSubject("Teste Email");
//		email.setMsg(motivo);
//		email.addTo("t800.hma@gmail.com");
//		//email.addTo("marianna.angelica@hotmail.com");
//		//email.addTo("hudson.silva@capgemini.com");
//		email.send();
//		
		
		
		
		
		
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("t800.hma@gmail.com", "lqceveoatljdctvm"));
		
		email.setSSLOnConnect(true);
		email.setFrom("t800.hma@gmail.com");
		email.setSubject("Teste Email");
		email.setMsg(motivo);
		email.addTo("hu.psilva@gmail.com");
		//email.addTo("marianna.angelica@hotmail.com");
		//email.addTo("hudson.silva@capgemini.com");
		email.send();
		
		
		
		
		
		
		
		
		System.out.println("-----Enviado email----");

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}