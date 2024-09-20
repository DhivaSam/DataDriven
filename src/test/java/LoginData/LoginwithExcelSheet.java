package LoginData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class LoginwithExcelSheet {

	
	static List<String> userNameList= new ArrayList<String>();
	static List<String> passwordList= new ArrayList<String>();
	public void getExcelSheet() throws IOException {
		FileInputStream excel=new FileInputStream("C:\\Users\\abc\\Desktop\\resume\\data.xlsx");
		Workbook wb=new XSSFWorkbook(excel);
		Sheet sheet=wb.getSheetAt(0);
		Iterator<Row> rowIterator=sheet.iterator();
		while(rowIterator.hasNext()) {
			Row rowvalue=rowIterator.next();
			Iterator<Cell> columnIterator=rowvalue.iterator();
			int i=2;
			while(columnIterator.hasNext()) {
				if(i%2==0) {
				userNameList.add(columnIterator.next().getStringCellValue());
				
				
			}
				else {
					passwordList.add(columnIterator.next().getStringCellValue());
				}
				i++;
			}
			
			
		}
	
	}
	
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
	
	public void excuteTest() throws InterruptedException {
		for(int i=0;i<userNameList.size();i++) {
			loginwithCorrectInfoPassword(userNameList.get(i),passwordList.get(i));
		}
	}
	public static void main(String [] args) throws IOException, InterruptedException {
		
		LoginwithExcelSheet les=new LoginwithExcelSheet();
		les.getExcelSheet();
		System.out.println(userNameList);
		System.out.println(passwordList);
		les.excuteTest();
		
	}
	
}
