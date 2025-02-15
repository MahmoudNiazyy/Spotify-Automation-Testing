import DataReader.JSONreader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class AddPalyListTest extends BaseTest {
    @DataProvider(name = "ValidRegister")
    public  Object[][] readvalidRegisterData()
    {
        return JSONreader.ReadJsonFile("RegisterData","ValidLoginData");
    }

    @Test(dataProvider = "ValidRegister" ,priority = 1)
    public void TestValidAddPlayList(HashMap<String,String> registerData) throws InterruptedException {
        LogInPage  logInPage= Header.ClickLogInButton(driver);

        String Email = registerData.get("Email");
        String Password = registerData.get("Password");

        logInPage.AddLogInData(Email,Password);
        Thread.sleep(2000);
        logInPage.ClickLogIn();

        AddPlayList addPlayList = new AddPlayList(driver);
        Thread.sleep(2000);
        addPlayList.Closer();
        Thread.sleep(2000);
        addPlayList.ClickOnSpotify();

        Thread.sleep(10000);
        addPlayList.AddSongToPlayList();
        Thread.sleep(2000);
        addPlayList.RunPlayList();






    }

}
