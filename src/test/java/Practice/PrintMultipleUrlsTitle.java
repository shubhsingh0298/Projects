package Practice;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class PrintMultipleUrlsTitle {
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
				for(String url:urls)
				{
					driver.get(url);
					@Nullable
					String title = driver.getTitle();
					System.out.println("Title of "+url+": "+title);
					
				}
				driver.quit();
	}

}
