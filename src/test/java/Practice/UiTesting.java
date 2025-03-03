package Practice;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class UiTesting {

	  // Method to send a single email notification
    public static void sendEmail(String subject, String body) {
        // Email configuration
        String host = "smtp.gmail.com"; // Gmail SMTP server
        String port = "587"; // SMTP port for Gmail
        String from = "shubham@raptorsupplies.co.uk"; // Replace with your email
        String password = "wgrpctucluvhgpdb"; // Replace with your email password (or use App Password)
        String to = "shubsingh0298@gmail.com"; // Recipient's email address

        // Setting up properties for Gmail SMTP server
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Creating a session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            // Compose the email
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(body);

            // Send the email
            Transport.send(message);
            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-agent=RaptorSuppliesDesk");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.raptorsupplies.com/pd/morse-drum/86");

        // Example flow to interact with the webpage
        driver.findElement(By.id("eve_38")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("eve_293")).click();
        Thread.sleep(6000);

        // Track multiple elements and store their initial states
        Map<String, String> initialState = new HashMap<>();

        // Get Invoice dimensions
        WebElement getInvoice = driver.findElement(By.id("eve_505"));
        Dimension getInvoiceDim = getInvoice.getSize();
        initialState.put("Get Invoice Dimensions", "Height: " + getInvoiceDim.height + ", Width: " + getInvoiceDim.width);

        // Print Button color
        WebElement printButton = driver.findElement(By.id("eve_350"));
        String printButtonColor = printButton.getCssValue("background-color");
        initialState.put("Print Button Color", printButtonColor);

        // entire Cart Summary RHS dimensions
        WebElement cartSummaryRHS = driver.findElement(By.xpath("//div[@class='cart-summary']"));
        Dimension cartSummaryDim = cartSummaryRHS.getSize();
        initialState.put("Cart Summary RHS", "Height: " + cartSummaryDim.height + ", Width: " + cartSummaryDim.width);

        // Checkout button color
        WebElement checkoutButton = driver.findElement(By.id("eve_187"));
        String checkoutButtonColor = checkoutButton.getCssValue("background-color");
        initialState.put("Checkout Button Color", checkoutButtonColor);

        // Payment methods options dimensions
        WebElement paymentMethods = driver.findElement(By.xpath("//div[@class='payment_images shopping-cart-payment-images']"));
        Dimension paymentMethodsDim = paymentMethods.getSize();
        initialState.put("Payment Methods Options", "Height: " + paymentMethodsDim.height + ", Width: " + paymentMethodsDim.width);

        // Discount field dimensions
        WebElement discountField = driver.findElement(By.cssSelector("div.block-discount-inner"));
        Dimension discountFieldDim = discountField.getSize();
        initialState.put("Discount Coupon Box", "Height: " + discountFieldDim.height + ", Width: " + discountFieldDim.width);

        // Apply button color
        WebElement applyButton = driver.findElement(By.id("eve_186"));
        String applyButtonColor = applyButton.getCssValue("background-color");
        initialState.put("Apply Button Color", applyButtonColor);

        // Capture initial text of flat 5% coupon code
        WebElement getTextOfFlatCoupon = driver.findElement(By.cssSelector("div.coupon-name "));
        String flatCouponText = getTextOfFlatCoupon.getText();
        initialState.put("Flat Coupon Text", flatCouponText);
        
     // Monitoring Payment Methods
        WebElement paymentMethodDiv = driver.findElement(By.cssSelector("div.payment_images.shopping-cart-payment-images"));
        List<WebElement> noOfPaymentOptions = paymentMethodDiv.findElements(By.tagName("span"));
        
        StringBuilder paymentOptions = new StringBuilder();
        for (WebElement paymentMethod : noOfPaymentOptions) {
            String paymentTitle = paymentMethod.getAttribute("title");
            paymentOptions.append(paymentTitle).append("\n");
        }
        initialState.put("Payment Methods", paymentOptions.toString());
        
//        
//     // Extracting Payment Summary Table size
//        WebElement paymentsummaryEntire = driver.findElement(By.id("cart-totals"));
//        Dimension paymentsummaryTable = paymentsummaryEntire.getSize();
//        System.out.println("Payment Summary Table height: " + paymentsummaryTable.height);
//        System.out.println("Payment Summary Table width: " + paymentsummaryTable.width);
//
//        // Fetch the "Sub-Total" row and its price value
//        WebElement subTotalRow = driver.findElement(By.cssSelector("tr.totals.sub"));
//        WebElement subTotalLabel = subTotalRow.findElement(By.cssSelector("th.mark"));
//        String subTotalText = subTotalLabel.getText(); // "Sub-Total"
//        WebElement subTotalPriceElement = subTotalRow.findElement(By.cssSelector("td.amount .price"));
//        String subTotalPrice = subTotalPriceElement.getText(); // "$625.41"
//
//        // Fetch the "Total Amount" row and its price value
//        WebElement totalAmountRow = driver.findElement(By.cssSelector("tr.grand.totals"));
//        WebElement totalAmountLabel = totalAmountRow.findElement(By.cssSelector("th.mark"));
//        String totalAmountText = totalAmountLabel.getText(); // "Total Amount"
//        WebElement totalAmountPriceElement = totalAmountRow.findElement(By.cssSelector("td.amount .price"));
//        String totalAmountPrice = totalAmountPriceElement.getText(); // "$625.41"
//
//        // Print the extracted values
//        System.out.println(subTotalText + ": " + subTotalPrice);
//        System.out.println(totalAmountText + ": " + totalAmountPrice);
//

        // Simulate waiting before checking for changes
        Thread.sleep(6000);

        // Now check the state after the delay and compare
        StringBuilder changes = new StringBuilder();
        boolean changeDetected = false;

        // Compare each element's state
        if (!initialState.get("Get Invoice Dimensions").equals("Height: " + getInvoice.getSize().height + ", Width: " + getInvoice.getSize().width)) {
            changes.append("Change detected in Get Invoice Dimensions.\n");
            changeDetected = true;
        }

        if (!initialState.get("Print Button Color").equals(printButton.getCssValue("background-color"))) {
            changes.append("Change detected in Print Button Color.\n");
            changeDetected = true;
        }

        if (!initialState.get("Cart Summary RHS").equals("Height: " + cartSummaryRHS.getSize().height + ", Width: " + cartSummaryRHS.getSize().width)) {
            changes.append("Change detected in Cart Summary RHS.\n");
            changeDetected = true;
        }

        if (!initialState.get("Checkout Button Color").equals(checkoutButton.getCssValue("background-color"))) {
            changes.append("Change detected in Checkout Button Color.\n");
            changeDetected = true;
        }

        if (!initialState.get("Payment Methods Options").equals("Height: " + paymentMethods.getSize().height + ", Width: " + paymentMethods.getSize().width)) {
            changes.append("Change detected in Payment Methods Options.\n");
            changeDetected = true;
        }

        if (!initialState.get("Discount Coupon Box").equals("Height: " + discountField.getSize().height + ", Width: " + discountField.getSize().width)) {
            changes.append("Change detected in Discount Coupon Box.\n");
            changeDetected = true;
        }

        if (!initialState.get("Apply Button Color").equals(applyButton.getCssValue("background-color"))) {
            changes.append("Change detected in Apply Button Color.\n");
            changeDetected = true;
        }

        if (!initialState.get("Flat Coupon Text").equals(flatCouponText)) {
            changes.append("Change detected in Flat Coupon Text.\n");
            changeDetected = true;
        }

        // Compare Payment Methods options
        WebElement currentPaymentMethodDiv = driver.findElement(By.cssSelector("div.payment_images.shopping-cart-payment-images"));
        List<WebElement> currentPaymentOptions = currentPaymentMethodDiv.findElements(By.tagName("span"));
        
        StringBuilder currentPaymentOptionsList = new StringBuilder();
        for (WebElement paymentMethod : currentPaymentOptions) {
            String paymentTitle = paymentMethod.getAttribute("title");
            currentPaymentOptionsList.append(paymentTitle).append("\n");
        }
        
        if (!initialState.get("Payment Methods").equals(currentPaymentOptionsList.toString())) {
            changes.append("Change detected in Payment Methods Options.\n");
            changeDetected = true;
        }
//        if (!initialState.get("Sub-Total").equals(subTotalPrice)) {
//            changes.append("Change detected in Sub-Total.\n");
//            changeDetected = true;
//        }
//
//        // Compare Total Amount
//        if (!initialState.get("Total Amount").equals(totalAmountPrice)) {
//            changes.append("Change detected in Total Amount.\n");
//            changeDetected = true;
//        }
    
        
        // Send a single email if any change is detected
        if (changeDetected) {
            sendEmail("Page Element Changes Detected", changes.toString());
        }
        else
        {
        	System.out.println("No changges detected");
        }
        // Quit the browser
        driver.quit();
    }
}
