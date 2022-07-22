package assignmentWeek2Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Image {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/");

		//Click on this image to go home page
		driver.findElement(By.xpath("//h5[text()='Image']")).click();
		driver.findElement(By.xpath("//img[@src='../images/home.png']")).click();
		driver.findElement(By.xpath("//h5[text()='Image']")).click();

		//Broken image		
		WebElement image = driver.findElement(By.xpath("//img[@src='../images/abcd.jpg']")); //Click the broken image
		String Click=image.getAttribute("onclick");
		if(Click==null) {
			System.out.println("Broken image and not clickable");
		}
		else {
			System.out.println("Is not broken image");
		}

		//org.openqa.selenium.ElementNotInteractableException -error 
		WebElement findElement = driver.findElement(By.xpath("//img[@src='../images/keyboard.png']"));
		Actions actions = new Actions(driver);
		actions.contextClick(findElement).click().perform();
		System.out.println(driver.getTitle());
	}

}
