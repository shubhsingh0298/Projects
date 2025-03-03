package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProgramToOpenEachUrlsInNewTab {

	public static void main(String[] args) {
		
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		
		String[] urls= {
				"https://www.google.com",
				"https://www.flipkart.com",
				"https://www.amazon.com",
				"https://www.selenium.dev",
				"https://www.facebook.com",
				"https://www.instagram.com",
				"https://www.myntra.com",
				"https://www.youtube.com",
				"https://www.skype.com",
				"https://www.shopperstack.com",
	};
		driver.get(urls[0]);
		System.out.println(driver.getTitle());
		
		for(int i=1;i<urls.length;i++)
		{
			driver.switchTo().newWindow(WindowType.TAB);
			
			driver.get(urls[i]);
			System.out.println("Title of urls"+(i+1)+": "+driver.getTitle());
		}
		driver.quit();

}
	}
