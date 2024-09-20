package LoginData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginWithCorrectInfo {
	
	String [][] data= {{"Admin" , "admin123"},
			{"Admin","admin"},
			{"admin","admin123"}
		
			
			
			
	};
	
	@DataProvider(name="logindata")
	public String [][]  dataprovoderData() {
		return data;
	}
@Test(dataProvider="logindata")


	public void loginwithCorrectInfoPassword(String uname, String password) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abc\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");  
		 
		  WebDriver driver=new ChromeDriver(); 
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		  driver.manage().window().maximize();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(uname);
		  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		  driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		  driver.quit();
	}
}
