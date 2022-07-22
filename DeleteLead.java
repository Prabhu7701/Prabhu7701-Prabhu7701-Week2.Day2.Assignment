package assignmentWeek2Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Creating lead to make sure the data available for delete function
		// Accessing the url and logging in 
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		WebElement logout = driver.findElement(By.className("decorativeSubmit"));
		String attribute = logout.getAttribute("Value");
		driver.findElement(By.linkText("CRM/SFA" )).click();

		//lead creation:
		driver.findElement(By.linkText("Leads" )).click();
		driver.findElement(By.linkText("Create Lead" )).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("ABCD");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Prabhu");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Shanmugam");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("TEST AAA");
		driver.findElement(By.name("departmentName")).sendKeys("IT");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Assignment for the week2. day1");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("TEST@Gmail.com");
		WebElement State = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select select = new Select(State);
		select.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();

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
		String LeadId = LeadcreationNumber.replaceAll("[^0-9]", "");
		System.out.println(LeadId);

		//Deleted the lead
		driver.findElement(By.xpath("//a[text()='Delete']")).click(); 
		System.out.println(LeadId +": Lead deleted sucessfually");

		//Searching the deleted Lead for validation
		driver.findElement(By.linkText("Find Leads")).click(); 
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(LeadId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click(); 
		Thread.sleep(5000);
		WebElement findElement = driver.findElement(By.xpath("//div[@id='ext-gen437']"));
		String text = findElement.getText();
		System.out.println(text);

		//Validation part is the lead deleted or not
		if(text.equalsIgnoreCase("No records to display")) {
			System.out.println("lead deleted");
		}
		else {
			System.out.println("XXX lead available and not delted XXXX");
		}

	}

}
