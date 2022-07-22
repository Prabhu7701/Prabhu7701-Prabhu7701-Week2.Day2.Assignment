package assignmentWeek2Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Link {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Accessing the url and logging in 
		driver.get("http://leafground.com/");
		driver.findElement(By.xpath("//h5[text()='HyperLink']")).click();

		//Go to Home Page link validation
		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[1]")).click();
		WebElement HomePageTitle = driver.findElement(By.xpath("//h1[@class='wp-heading']"));
		String text = HomePageTitle.getText();
		System.out.println(text);

		if (text.contentEquals("Locators and Selenium Interactions"))
		{
			System.out.println("User lands on Home page");
		}
		else
		{
			System.out.println("User not lands on Home page");
		}

		//Find where am supposed to go without clicking me?
		driver.findElement(By.xpath("//h5[text()='HyperLink']")).click();
		WebElement linkText = driver.findElement(By.xpath("//a[contains(text(),'am supposed to go')]"));
		String text1 = linkText.getAttribute("href");
		System.out.println(text1);

		//Verify am I broken?
		driver.findElement(By.xpath("//a[contains(text(),'Verify am I ')]")).click();
		System.out.println("Page is broken: "+ driver.getTitle().contains("404"));
		driver. navigate(). back();

		// Go to Home Page (Interact with same link name)
		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[2]")).click();
		driver.findElement(By.xpath("//h5[text()='HyperLink']")).click();

		//How many links are available in this page?
		int size = driver. findElements(By.tagName("a")).size();
		System.out.println("Totla links in the page are : " + size);
	}

}
