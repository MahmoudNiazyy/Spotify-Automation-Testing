import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.*;


public class RegisterPage {
    WebDriver driver ;
    WebDriverWait wait;


    // Locator
    private final By RegisterForm = By.xpath("//h1[@data-encore-id = \"text\"]");

    private final By Email = By.xpath("//input[@type = \"email\"]");
    private final By NextButton = By.xpath("//button[contains(@data-testid, \"submit\")]");
    private final By NextButton2 = By.xpath("//button[contains(@data-encore-id, \"buttonPrimary\")]");
    private final By Closer = By.xpath("//button[@class = \"onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon\"]");

    private final By Password = By.xpath("//input[contains(@type, \"password\")]");

    private final By Name = By.xpath("//input[contains(@name, \"displayName\")]");
    private final By Day = By.xpath("//input[contains(@name, \"day\")]");
    private final By Month = By.xpath("//select[contains(@data-testid, \"birthDateMonth\")]");
    private final By Years = By.xpath("//input[contains(@placeholder, \"yyyy\")]");

    private final By MaleGender = By.xpath("//span[contains(text(), \"Man\")]");
    private final By FemaleGender = By.xpath("//span[contains(text(), \"Woman\")]");
    private final By SendANews = By.xpath("//label[@for= \"checkbox-marketing\"]");
    private final By ShareARegister = By.xpath("//label[@for= \"checkbox-privacy\"]");
    private final By ProfileAssert = By.xpath("//span[@class= \"svelte-14q5f57\"]");









    public RegisterPage (WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver , Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(RegisterForm));
    }


    public void EnterEmail(String email )
    {
        driver.findElement(Email).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Closer));
        driver.findElement(Closer).click();
    }

    public void ClickNextButton()
    {
        driver.findElement(NextButton).click();
    }


    public void EnterPassword(String pass ) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Password));
        driver.findElement(Password).sendKeys(pass);


      sleep(2000);
        driver.findElement(NextButton2).click();


    }
    public void EnterINfo ( String Gender , String name , String day , String month , String year ) throws InterruptedException {
        driver.findElement(Name).sendKeys( name);

        driver.findElement(Day).sendKeys(day);

        Select DropMonth = new Select(driver.findElement(Month));
        DropMonth.selectByIndex(Integer.valueOf(month));

        driver.findElement(Years).sendKeys(year);

        if (Gender.equalsIgnoreCase("male"))
        {
            driver.findElement(MaleGender).click();
        } else if (Gender.equalsIgnoreCase("female")) {
            driver.findElement(FemaleGender).click();
        }

        sleep(2000);
        driver.findElement(NextButton2).click();

    }

    public void Terms_and_Conditions() throws InterruptedException {

        driver.findElement(SendANews).click();
        driver.findElement(ShareARegister).click();
        sleep(2000);
        driver.findElement(NextButton2).click();
    }

 public String GetProfileForAssert()
    {
        return driver.findElement(ProfileAssert).getText();
    }

}
