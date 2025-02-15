import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInPage {

    WebDriver driver ;
    WebDriverWait wait;

    // Locator
    private final By LogInForm = By.xpath("//h1[contains(@variant, \"titleLarge\")]");
    private final By Email = By.xpath("//input[contains(@id, \"login-username\")]");
    private final By Password = By.xpath("//input[contains(@id,\"login-password\")]");
    private final By LogInButton = By.xpath("//button[contains(@id,\"login-button\")]");


    public LogInPage(WebDriver driver)
    {

        this.driver = driver;
        this.wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LogInForm));
    }

    public void AddLogInData(String EmailData,String PasswordData)
    {
        driver.findElement(Email).sendKeys(EmailData);
        driver.findElement(Password).sendKeys(PasswordData);
    }

    public void ClickLogIn()
    {
        driver.findElement(LogInButton).click();
    }



}
