package assignmentWeek2Day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Accessing the url 
		driver.get("http://leafground.com/");

		//Enter your email address
		driver.findElement(By.xpath("//h5[text()='Checkbox']")).click();

		//Select the languages that you know?
		driver.findElement(By.xpath("(//label[text()='Select the languages that you know?']/following-sibling::input)[1]")).click();
		driver.findElement(By.xpath("(//label[text()='Select the languages that you know?']/following-sibling::input)[3]")).click();

		//Confirm Selenium is checked
		boolean selected = driver.findElement(By.xpath("//label[text()='Confirm Selenium is checked']/following-sibling::input")).isSelected();
		System.out.println("Is Check box is selected : " + selected);

		//Select all below checkboxes
		List Check = driver.findElements(By.xpath("(//label[text()='Select all below checkboxes ']/following-sibling::input)"));
		int Size = Check.size();     
		System.out.println("Number of otion available: " + Size);
		for(int i = 0; i<Size; i++) {
			((WebElement) Check.get(i)).click();
		}

		//DeSelect only checked
		List<WebElement> Check1 = driver.findElements(By.xpath("//label[text()='DeSelect only checked']/following-sibling::input"));
		int Size1 = Check1.size(); 
		for(int j = 0; j<Size1; j++) {
			if(((WebElement) Check1.get(j)).isSelected()){
				((WebElement) Check1.get(j)).click();
			}
		}

	}

}
