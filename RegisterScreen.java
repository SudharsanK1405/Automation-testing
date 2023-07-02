import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RegisterScreen {
    public static void main(String[] args) {
        System.setProperty("WebDriver.Chrome.Driver", "C:\\Users\\jaggu\\Documents\\chromedriver_win32.exe");

        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");


        WebDriver driver = new ChromeDriver(options);

        
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");

        
        testValidSignup(driver);

        
        negativeSignupIncorrectPassword(driver);
        
        negativeSignupWithoutAgree(driver);
        
        negativeSignupInvalidMobileNumber(driver);

        
        driver.quit();
    }

    //# Positive Test Case 
    public static void testValidSignup(WebDriver driver) {
        // Positive test scenario with valid inputs
        enterText(driver, "input-firstname", "Sudharsan");
        enterText(driver, "input-lastname", "K");
        enterText(driver, "input-email", "sudharshan22@gmail.com");
        enterText(driver, "input-telephone", "9832453544");
        enterText(driver, "input-password", "Tress@123");
        enterText(driver, "input-confirm", "Tress@123");
        clickCheckbox(driver, "1");
        clickButton(driver, "Continue");

        
    }

    
    public static void negativeSignupIncorrectPassword(WebDriver driver) {
        // Negative test scenarios with invalid inputs
        enterText(driver, "input-firstname", "Sudharsan");
        enterText(driver, "input-lastname", "K");
        enterText(driver, "input-email", "sudharshan22@gmail.com");
        enterText(driver, "input-telephone", "9025023991");
        enterText(driver, "input-password", "password123");
        enterText(driver, "input-confirm", "password321");
        clickCheckbox(driver, "1");
        clickButton(driver, "Continue");

        
    }
    public static void negativeSignupWithoutAgree(WebDriver driver) {
        // Negative test scenarios with invalid inputs
        enterText(driver, "input-firstname", "Sudharsan");
        enterText(driver, "input-lastname", "K");
        enterText(driver, "input-email", "sudharshan22@gmail.com");
        enterText(driver, "input-telephone", "9025023991");
        enterText(driver, "input-password", "password123");
        enterText(driver, "input-confirm", "password123");
        clickButton(driver, "Continue");

        
    }
    
    public static void negativeSignupInvalidMobileNumber(WebDriver driver) {
        // Negative test scenarios with invalid inputs
        enterText(driver, "input-firstname", "Sudharsan");
        enterText(driver, "input-lastname", "K");
        enterText(driver, "input-email", "sudharshan22@gmail.com");
        enterText(driver, "input-telephone", "902502399");
        enterText(driver, "input-password", "password123");
        enterText(driver, "input-confirm", "password123");
        clickCheckbox(driver, "1");
        clickButton(driver, "Continue");

        
    }
    

    public static void enterText(WebDriver driver, String elementId, String text) {
        WebElement element = driver.findElement(By.id(elementId));
        element.clear();
        element.sendKeys(text);
    }
    public static void clickCheckbox(WebDriver driver, String checkboxName) {
        WebElement checkbox = driver.findElement(By.cssSelector("input[name='" + checkboxName + "']"));
        checkbox.click();
    }

    public static void clickButton(WebDriver driver, String buttonText) {
        WebElement button = driver.findElement(By.cssSelector("input.btn.btn-primary[value='" + buttonText + "']"));
        button.click();
    }


}
