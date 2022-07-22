package assignmentWeek2Day2;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Table {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/");
		driver.findElement(By.xpath("//h5[text()='Table']")).click();

		//Get the count of number of columns
		WebElement findElement = driver.findElement(By.xpath("//div[@id='contentblock']/section/div[1]/table"));
		List<WebElement> findElements = findElement.findElements(By.tagName("th"));
		int Col = findElements.size();
		System.out.println("Number of columns: "+ Col);

		//Get the count of number of rows
		WebElement findElement1 = driver.findElement(By.xpath("//div[@id='contentblock']/section/div[1]/table"));
		List<WebElement> findElements1 = findElement.findElements(By.tagName("tr"));
		int row = findElements1.size();
		System.out.println("Number of rows: " + row);

		//Get the progress value of 'Learn to interact with Elements'
		WebElement finElement2=driver.findElement(By.xpath("//td/font[contains(text(),'Learn to interact with')][1]/following::td[1]"));
		System.out.println("The progress value is: " + finElement2.getText());

		//Check the vital task for the least completed progress
		List <WebElement> fields = driver.findElements(By.xpath("(//td/font[contains(text(),'Learn to interact with')][1]/following::td[1])"));
		int SameRecords = fields.size();
		System.out.println(SameRecords);
		int[] value=new int[3];
		String text1,text2;
		int Replace;

		for(int i=0;i<SameRecords;i++) {				
			text1=fields.get(i).getText();
			text1= text1.replace("%", "");
			value[i]=Integer.parseInt(text1);	
			System.out.println(text1);
		}
		Arrays.sort(value);
		for(int j=0;j<SameRecords;j++)
		{
			WebElement leastvalue =  fields.get(j);
			text2 = fields.get(j).getText();
			text2= text2.replace("%", "");
			Replace=Integer.parseInt(text2);
			if(value[0]==Replace) {  
				leastvalue.findElement(By.xpath("following::td[1]/input")).click(); 
			}

		}

	}

}
