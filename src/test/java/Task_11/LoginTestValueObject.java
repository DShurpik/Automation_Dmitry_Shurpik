package Task_11;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.valueObject.LoginPage;
import pageObjects.saucedemo.valueObject.ProductPage;

public class LoginTestValueObject extends BaseTest {

    String url = "https://www.saucedemo.com/";
    @Test
    public void test1(){
        LoginPage loginPage = new LoginPage(){{
            setUserName("standard_user");
            setPassword("secret_sauce");
        }};
        new LoginPage()
                .open(url)
                .enterData(loginPage)
                .clickLogin();
        new ProductPage()
                .verifyPageTitle();

    }
}
