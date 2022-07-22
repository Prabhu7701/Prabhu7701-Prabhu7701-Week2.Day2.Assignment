package assignmentWeek2Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Button {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Accessing the url 
		driver.get("http://leafground.com/");
		driver.findElement(By.xpath("//h5[text()='Button']")).click();

		//Click button to travel home page
		driver.findElement(By.xpath("//button[text()='Go to Home Page']")).click();

		//Find position of button (x,y)
		driver.findElement(By.xpath("//h5[text()='Button']")).click();
		int x = driver.findElement(By.xpath("//button[text()='Get Position']")).getLocation().getX();
		int y = driver.findElement(By.xpath("//button[text()='Get Position']")).getLocation().getY();
		System.out.println("position of button:  " + x + " and "+ y);

		//Find button color
		String color = driver.findElement(By.xpath("//button[@id='color']")).getCssValue("background-color");
		System.out.println("Color of the button is: " +color);

		//Find the height and width
		Dimension size = driver.findElement(By.xpath("//button[@id='size']")).getSize();
		System.out.println("Height and width are : "+size);

	}

}
