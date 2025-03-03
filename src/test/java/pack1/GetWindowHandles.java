package pack1;

import java.util.Set;

import org.openqa.selenium.By;
//getWindowHandles(): It is used to handle of a  multiple window, it returns the set of strings- Set<String> value.
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class GetWindowHandles {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@href='http://www.orangehrm.com']")).click();
		Set<String> windowHandle = driver.getWindowHandles();
		
		for(String window:windowHandle)
		{
			System.out.println(window);
		}
		
		driver.close();

	}

}
