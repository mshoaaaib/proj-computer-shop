package proj1;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class functions {

	WebDriver driver;
	excelprc obj=new excelprc();
	
	@FindBy(xpath="//a[@class='departments-menu-v2-title']")
	WebElement Products;
	
	@FindBy(xpath="//ul[@id='menu-all-departments-1']//li[@id='menu-item-4761']")
	WebElement laptops;
	
	@FindBy(xpath="//h1[@class='product_title entry-title']")
	WebElement name;
	
	@FindBy(xpath="(//span[@class='woocommerce-Price-amount amount'])[2]")
	WebElement price;
	
	@FindBy(xpath="//div[@class='woocommerce-product-details__short-description']")
	WebElement description;
	
	@FindBy(xpath="//select[@name='ppp']")
	WebElement no_of_prod;
	
	@FindBy(xpath="//img[@class='wp-post-image jetpack-lazy-image jetpack-lazy-image--handled']")
	WebElement image;
	
	public functions(WebDriver d) {
		driver=d;
		PageFactory.initElements(d,this);
	}

	public void function() throws Exception
	{
		
		
		driver.manage().window().maximize();
		Actions hover=new Actions(driver);
		hover.moveToElement(Products).perform();
		Thread.sleep(1000);
		laptops.click();
		Select dd=new Select(no_of_prod);
		dd.selectByVisibleText("Show All");
		Thread.sleep(2000);
		XSSFWorkbook workbook1=new XSSFWorkbook();
		XSSFSheet sheet1=workbook1.createSheet("Computer Details");
		File fil=new File("C:\\Users\\muham\\eclipse-workspace\\proj1\\details.xlsx");
		FileOutputStream fos=new FileOutputStream(fil);
		workbook1.write(fos);
		
		obj.ExcelFn("Name","Price","Details", 0, 1);
		for (int i=1; i<=3; i++)
		{
			driver.findElement(By.xpath("(//div[@class='product-thumbnail product-item__thumbnail'])["+i+"]")).click();//xpath to get each picture
			String desc=description.getText();
			String detail= name.getText();
			String Price= price.getText();
			
			
			Actions right_click=new Actions(driver);
			right_click.contextClick(image).build().perform();
			Robot robot = new Robot();
			for(int n=0; n<2;n++)
			{
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			int j=1;
			//for(int j=1; j<3; j++)
			//{
				obj.ExcelFn(detail,Price,desc, i, j);
				
				
			//}
			driver.navigate().back();
			Thread.sleep(3000);
			
			
			
		}
	}

	

}


