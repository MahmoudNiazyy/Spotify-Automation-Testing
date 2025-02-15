import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {



    private final static By RegisterButton = By.xpath("//a[@data-ga-action = \"sign-up\"]");
    private final static By LogInButton = By.xpath("//a[@data-ga-action = \"log-in\"]");

    private final static By UserInfo = By.cssSelector("div.header a[href*=\"info\"]");

    public static RegisterPage ClickRegisterButton(WebDriver driver)
    {
        driver.findElement(RegisterButton).click();

        return new RegisterPage(driver);
    }


    public static LogInPage ClickLogInButton(WebDriver driver)
    {
        driver.findElement(LogInButton).click();

        return new LogInPage(driver);
    }

    public static String GetUserName(WebDriver driver)
    {
        return driver.findElement(UserInfo).getText();
    }

}
