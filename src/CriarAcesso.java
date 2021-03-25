import static org.junit.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class CriarAcesso {
	
	WebDriver driver;
	
	@Dado("^Acessar a página de cadastro de usuário$")
	public void acessar_a_página_de_cadastro_de_usuário() {
	    
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

	@Quando("^Solicitar o registro do usuário$")
	public void solicitar_o_registro_do_usuário() {
	   
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]")).click();
	}
	
	@Então("^o sistema informa a mensagem$")
	public void o_sistema_informa_a_mensagem() {
		
	    String urlpagina = driver.getCurrentUrl();
	    
	    assertEquals(urlpagina, "http://practice.automationtesting.in/my-account/");
	    
	    try {
			
			File evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(evidencia, new File("C:\\Users\\Suporte\\Documents\\Projeto\\Praticando\\ProjetoPrat02\\evidências\\Validação de cadastro com sucesso.png"));
			
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
	    
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

	@Então("^o sistema informa a mensagem uma mensagem$")
	public void o_sistema_informa_a_mensagem_uma_mensagem() {

		String mensagem = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li/strong")).getText();
		
		assertEquals(mensagem, "Error:");
		
		try {
		
		File evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(evidencia, new File("C:\\Users\\Suporte\\Documents\\Projeto\\Praticando\\ProjetoPrat02\\evidências\\Validação de campo obrigatório.png"));
		
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		driver.close();
		}
		

}
