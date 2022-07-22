package assignmentWeek2Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// please run the Create lead and then run this program
		// Accessing the url and logging in 
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		WebElement logout = driver.findElement(By.className("decorativeSubmit"));
		String attribute = logout.getAttribute("Value");

		// Login validation
		if (attribute.equals("Logout"))
		{
			System.out.println("Logged in Successfully");
		}
		else {
			System.out.println("Not Loggedin");
		}

		driver.findElement(By.linkText("CRM/SFA" )).click();

		//Searching lead:
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click(); 
		driver.findElement(By.xpath("(//label[text()='First name:'])[3]/following::input[@name='firstName']")).sendKeys("prabhu");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click(); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click(); 

		//Edit the lead
		driver.findElement(By.xpath("//a[text()='Edit']")).click(); 
		String FN1 = "First Name updated";
		driver.findElement(By.name("firstNameLocal")).clear();
		driver.findElement(By.name("firstNameLocal")).sendKeys(FN1);
		driver.findElement(By.className("smallSubmit")).click();

		WebElement updateFirstName = driver.findElement(By.xpath("//span[@id='viewLead_firstNameLocal_sp']"));
		String FN2 = updateFirstName.getText();
		System.out.println(FN2);

		if(FN1.equalsIgnoreCase(FN2)) {
			System.out.println("Lead upate sucessfully");
		}
		else {
			System.out.println("Lead Not upate sucessfully");
		}



	}

}
