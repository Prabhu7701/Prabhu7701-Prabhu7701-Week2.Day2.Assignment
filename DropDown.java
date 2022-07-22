package assignmentWeek2Day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Accessing the url
		driver.get("http://leafground.com/");

		//Select training program using Index
		driver.findElement(By.xpath("//h5[text()='Drop down']")).click();
		WebElement DropDown1 = driver.findElement(By.xpath("//select[@id='dropdown1']"));
		Select value =new Select (DropDown1);
		value.selectByIndex(2);

		//Select training program using Text
		WebElement DropDown2 = driver.findElement(By.xpath("//select[@name='dropdown2']"));
		Select valueA =new Select (DropDown2);
		valueA.selectByVisibleText("Selenium");

		//Select training program using Value
		WebElement DropDown3 = driver.findElement(By.xpath("//select[@id='dropdown3']"));
		Select valueB =new Select (DropDown3);
		valueB.selectByValue("3");

		//Get the number of dropdown options
		WebElement DropDown4 = driver.findElement(By.xpath("//select[@class='dropdown']"));
		Select valueC =new Select (DropDown4);
		List<WebElement> options = valueC.getOptions();
		int size = options.size();
		System.out.println("Options available count is " + size);

		//You can also use sendKeys to select
		WebElement findElement = driver.findElement(By.xpath("(//div[@class='example'])[5]"));
		Actions actions = new Actions(driver);
		actions.click(findElement).sendKeys(Keys.DOWN, Keys.DOWN, Keys.ENTER).perform();

		//Select multiple options
		WebElement DropDown5 = driver.findElement(By.xpath("//option[text()='Select your programs']/.."));
		Select valueD =new Select (DropDown5);
		valueD.selectByVisibleText("Selenium");
		valueD.selectByVisibleText("Appium");
		
	}

}
