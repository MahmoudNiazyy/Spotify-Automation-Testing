import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class AddPlayList {
    WebDriver driver;
    WebDriverWait wait;
    private final By Closer = By.xpath("//button[@class = \"onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon\"]");

    private final By SpotifyButton   = By.xpath("//span[@class=\"mh-header-primary svelte-1gcdbl9\"]");
    private final By ClickOnSong   = By.xpath("//div[@aria-labelledby=\"card-title-spotify:playlist:37i9dQZF1DX6hn7LleMPUw-0 card-subtitle-spotify:playlist:37i9dQZF1DX6hn7LleMPUw-0\"]");
    private final By selectButton   = By.xpath("//div[contains(text(),\"عامل حكاوي وبتاع دكن ( يلا يا جربانه )\")]");
    private final By AddToPlayList   = By.xpath("//button[@aria-label= \"More options for عامل حكاوي وبتاع دكن ( يلا يا جربانه )\"]");
    private final By MyPlayList   = By.xpath("//span[contains(text(),\"Add to playlist\")]");
    private final By SelectMyPlayList   = By.xpath("//button//span[contains(text(),\"My Playlist #1\")]");
    private final By RunPlayList   = By.xpath("//button[@aria-label=\"Play My Playlist #1\"]");

    public AddPlayList(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver , Duration.ofSeconds(20));
    }

    public void Closer()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Closer));
        driver.findElement(Closer).click();
    }
    public void ClickOnSpotify()
    {
        driver.findElement(SpotifyButton).click();
    }

    public void AddSongToPlayList() throws InterruptedException {
        sleep(1000);
        driver.findElement(ClickOnSong).click();
        sleep(5000);
        driver.findElement(selectButton).click();
        sleep(5000);
        driver.findElement(AddToPlayList).click();
        sleep(5000);
        driver.findElement(MyPlayList).click();
        sleep(5000);
        driver.findElement(SelectMyPlayList).click();
    }

    public void RunPlayList() throws InterruptedException {
        driver.findElement(RunPlayList).click();
        sleep(20000);
    }
}
