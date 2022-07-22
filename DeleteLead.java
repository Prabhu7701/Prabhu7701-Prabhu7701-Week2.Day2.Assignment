package assignmentWeek2Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();


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

		//Getting the lead Id
		WebElement Leadid = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']"));
		String LeadcreationNumber = Leadid.getText();
		//System.out.println(LeadcreationNumber);
		String LeadId = LeadcreationNumber.replaceAll("[^0-9]", "");
		System.out.println(LeadId);

		//Deleted the lead
		driver.findElement(By.xpath("//a[text()='Delete']")).click(); 
		System.out.println(LeadId +": Lead deleted sucessfually");

		//Search Lead
		driver.findElement(By.linkText("Find Leads")).click(); 
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(LeadId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click(); 
		Thread.sleep(5000);
		WebElement findElement = driver.findElement(By.xpath("//div[@id='ext-gen437']"));
		String text = findElement.getText();
		System.out.println(text);

		//Validation is the lead deleted or not
		if(text.equalsIgnoreCase("No records to display")) {
			System.out.println("lead deleted");
		}
		else {
			System.out.println("XXX lead available and not delted XXXX");
		}

	}

}
