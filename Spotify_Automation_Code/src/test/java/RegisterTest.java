import DataReader.JSONreader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RegisterTest extends BaseTest {
   // RegisterPage registerPage= Header.ClickRegisterButton(driver);

    @DataProvider(name = "ValidRegister")
    public  Object[][] readvalidRegisterData()
    {
       return JSONreader.ReadJsonFile("RegisterData","ValidRegisterData");
    }

    @Test (dataProvider = "ValidRegister" ,priority = 1)
    public void TestValidRegister(HashMap<String,String> registerData) throws InterruptedException {
        RegisterPage  registerPage= Header.ClickRegisterButton(driver);

        String Email = registerData.get("Email");
        String Password = registerData.get("Password");
        String Gender = registerData.get("Gender");
        String Name = registerData.get("Name");
        String Day = registerData.get("Day");
        String Month = registerData.get("Month");
        String Year = registerData.get("Year");

        registerPage.EnterEmail(Email);
        registerPage.ClickNextButton();
        registerPage.EnterPassword(Password);

        registerPage.EnterINfo(Gender , Name , Day,Month,Year);

        registerPage.Terms_and_Conditions();

        Thread.sleep(20000);
        assertEquals(registerPage.GetProfileForAssert(),"Profile");

    }





}


