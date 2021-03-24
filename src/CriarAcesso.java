import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Ent�o;
import cucumber.api.java.pt.Quando;

public class CriarAcesso {
	
	WebDriver driver;
	
	@Dado("^Acessar a p�gina de cadastro de usu�rio$")
	public void acessar_a_p�gina_de_cadastro_de_usu�rio() {
	    
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\Chrome\\89\\chromedriver.exe");
	
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://practice.automationtesting.in/my-account/");
		
	}

	@Dado("^Informar o \"([^\"]*)\"$")
	public void informar_o(String email) {
	    
		driver.findElement(By.xpath("//*[@id=\"reg_email\"]")).sendKeys(email);
	}

	@Dado("^Informar a \"([^\"]*)\"$")
	public void informar_a(String senha) {
	    
		driver.findElement(By.xpath("//*[@id=\"reg_password\"]")).sendKeys(senha);
	}

	@Quando("^Solicitar o registro do usu�rio$")
	public void solicitar_o_registro_do_usu�rio() {
	   
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]")).click();
	}
	
	@Ent�o("^o sistema informa a mensagem$")
	public void o_sistema_informa_a_mensagem() {
		
	    String urlpagina = driver.getCurrentUrl();
	    
	    assertEquals(urlpagina, "http://practice.automationtesting.in/my-account/");
	    
	    driver.close();
	}

	
	@Dado("^Informar o email$")
	public void informar_o_email() {
	   
		driver.findElement(By.xpath("//*[@id=\"reg_email\"]")).sendKeys("");
	}

	@Dado("^Informar a senha$")
	public void informar_a_senha() {
	    
		driver.findElement(By.xpath("//*[@id=\"reg_password\"]")).sendKeys("");
	}

	@Ent�o("^o sistema informa a mensagem uma mensagem$")
	public void o_sistema_informa_a_mensagem_uma_mensagem() {

		String mensagem = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li/strong")).getText();
		
		assertEquals(mensagem, "Error:");
		
		driver.close();
	}



}
