package orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;

/**
 * Project-2 - ProjectName : com-orangehrmlive
 * BaseUrl = https://opensource-demo.orangehrmlive.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Forgot your password?’ link.
 * 7. Print the current url.
 * 8. Navigate back to the login page.
 * 9. Refresh the page.
 * 10. Enter the email to email field.
 * 11. Enter the password to password field.
 * 12. Click on Login Button.
 * 13. Close the browser.
 */
public class OrangeHrmLive {
    static String browser = "Chrome";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        // 1. Setup Multiple browser.
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Internet Explorer")) {
            driver = new InternetExplorerDriver();
        } else {
            System.out.println("Wrong browser name");
        }
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //Implicitly wait time
        driver.manage().window().maximize(); // Maximise the window
        // 2. Open URL
        driver.get(baseUrl);

        // 3. Print the title of the page.
        System.out.println("The title of the page is : " + driver.getTitle());

        // 4. Print the current url.
        System.out.println("The current url is : " + driver.getCurrentUrl());

        // 5. Print the page source.
        System.out.println("The current source of page is : " + driver.getPageSource());

        //6. Click on ‘Forgot your password?’ link.
        WebElement clickLink = driver.findElement(By.className("orangehrm-login-forgot"));
        clickLink.click();
        Thread.sleep(3000);

        // 7. Print the current url.
        System.out.println("The current url is " + driver.getCurrentUrl());

        // 8. Navigate back to the login page.
        driver.navigate().back();

        // 9. Refresh the page.
        driver.navigate().refresh();

        // 10. Enter the email to email field.
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("Admin");

        //11. Enter the password to password field
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        Thread.sleep(3000);

        //12. Click on Login Button.
        WebElement loginClick = driver.findElement(By.xpath("(//button[@type='submit'])"));
        loginClick.click();
        Thread.sleep(5000);

        //13. Close the browser
        driver.quit();
    }
}
