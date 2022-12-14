package proj1;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {
	
	WebDriver driver=new ChromeDriver();
	functions tasks=new functions(driver);
	
	@BeforeMethod
	public void once_run()
	{
		driver.get("https://www.galaxy.pk/");	
	}
		
	
	
  @Test
  public void Test() throws Exception {
	  
	  tasks.function();
	  
  }
}
