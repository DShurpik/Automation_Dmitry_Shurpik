package Task_11;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.valueObject.LoginPage;
import pageObjects.saucedemo.valueObject.ProductPage;

public class LoginTestValueObject extends BaseTest {

    //@Parameters({"url", "userName", "password"})
    @Test
    public void test1(){
        LoginPage loginPage = new LoginPage(){{
            setUserName(properties.getProperty("username"));
            setPassword(properties.getProperty("password"));
        }};

        new LoginPage()
                .open(properties.getProperty("url"))
                .enterData(loginPage)
                .clickLogin();
        new ProductPage()
                .verifyPageTitle();

    }
}
