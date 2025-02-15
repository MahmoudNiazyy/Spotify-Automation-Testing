import DataReader.JSONreader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LogInTest extends BaseTest{



    @DataProvider(name = "ValidRegister")
    public  Object[][] readvalidRegisterData()
    {
        return JSONreader.ReadJsonFile("RegisterData","ValidLoginData");
    }

    @Test (dataProvider = "ValidRegister" ,priority = 1)
    public void TestValidLogIn(HashMap<String,String> registerData) throws InterruptedException {
        LogInPage  logInPage= Header.ClickLogInButton(driver);

        String Email = registerData.get("Email");
        String Password = registerData.get("Password");

        logInPage.AddLogInData(Email,Password);
        Thread.sleep(2000);
        logInPage.ClickLogIn();



    }





}
