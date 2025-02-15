import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    WebDriver driver;





    @BeforeMethod
    public void SetUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.spotify.com/eg-en/premium/");

    }

    @AfterMethod
    public void CloseSite() throws InterruptedException {
        Thread.sleep(500);
        driver.close();

    }
}
