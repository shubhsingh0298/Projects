package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Webtable {
	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
        options.addArguments("user-agent=RaptorSuppliesDesk");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.raptorsupplies.com/pd/morse-drum/86"); // Replace with your URL
        Thread.sleep(3000);
        driver.findElement(By.id("eve_38")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("eve_293")).click();
		Thread.sleep(10000);

		WebElement paymentsummaryEntire = driver.findElement(By.id("cart-totals"));
		Dimension paymentsummaryTable = paymentsummaryEntire.getSize();
		System.out.println("Payment Summary Table height: "+paymentsummaryTable.height);
		System.out.println("Payment Summary Table width:" + paymentsummaryTable.width);
		
		WebElement subTotalRow = driver.findElement(By.cssSelector("tr.totals.sub"));
        WebElement subTotalLabel = subTotalRow.findElement(By.cssSelector("th.mark"));
        String subTotalText = subTotalLabel.getText(); // "Sub-Total"
        WebElement subTotalPriceElement = subTotalRow.findElement(By.cssSelector("td.amount .price"));
        String subTotalPrice = subTotalPriceElement.getText(); // "$625.41"

        // Fetch the "Total Amount" row and its price value
        WebElement totalAmountRow = driver.findElement(By.cssSelector("tr.grand.totals"));
        WebElement totalAmountLabel = totalAmountRow.findElement(By.cssSelector("th.mark"));
        String totalAmountText = totalAmountLabel.getText(); // "Total Amount"
        WebElement totalAmountPriceElement = totalAmountRow.findElement(By.cssSelector("td.amount .price"));
        String totalAmountPrice = totalAmountPriceElement.getText(); // "$625.41"

        // Print the extracted values
        System.out.println(subTotalText + " " + subTotalPrice);
        System.out.println(totalAmountText + ": " + totalAmountPrice);
        
        

        // Close the browser after fetching the data
        driver.quit();
    }




}
