package assignmentWeek2Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edit {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Accessing the url and logging in 
		driver.get("http://leafground.com/");

		//Enter your email address
		driver.findElement(By.xpath("//h5[text()='Edit']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("TEST@ABC.com");

		//Append a text and press keyboard tab		
		driver.findElement(By.xpath("//input[contains(@Value,'Append')]")).sendKeys(Keys.ADD+ "Updated");

		//Get default text entered
		String text = driver.findElement(By.xpath("//input[@value='TestLeaf']")).getAttribute("value");
		System.out.println("Default text is " + text);

		//Clear the text
		driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();

		//driver.findElement(By.xpath("(//input[@name='username'])[1]"))
		Boolean Field =driver.findElement(By.xpath("//input[@disabled='true']")).isEnabled();
		if(Field) {
			System.out.println("Button is Enabled");
		}
		else {
			System.out.println("Buttoin is Disabled");
		}

	}
}

