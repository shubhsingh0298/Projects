package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetWindowHandle {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String singleWindow = driver.getWindowHandle();
		System.out.println(singleWindow);
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@href='http://www.orangehrm.com']")).click();
	}

}


//getWindowHandle(): It is used to handle of a single window, it returns the string value.You will get alpha-numeric value. 
//Everytime you will get new values while running script.

//getWindowHandles(): It is used to handle of a  multiple window, it returns the set of strings- Set<String> value.