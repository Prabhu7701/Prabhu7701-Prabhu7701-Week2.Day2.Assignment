
package assignmentWeek2Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Launch the url
		driver.get("https://en-gb.facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Clicking the Create account button
		driver.findElement(By.xpath("//a[contains(text(),'Create New Account')]")).click();

		//Filling the fields
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("TESTA");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("TESTB");
		driver.findElement(By.xpath("(//div[@class='_5dbb'])[3]//input")).sendKeys("9876543210");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("TEST@123!");
		WebElement dropdown1=driver.findElement(By.id("day"));
		Select A1=new Select(dropdown1);
		A1.selectByValue("16");
		Select A2=new Select(driver.findElement(By.id("month")));
		A2.selectByIndex(5);
		Select A3=new Select(driver.findElement(By.id("year")));
		A3.selectByValue("1999");
		driver.findElement(By.xpath("//input[@value='1']")).click();

		//Clicking sign-up button
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		System.out.println(driver.getTitle());
	}

}



