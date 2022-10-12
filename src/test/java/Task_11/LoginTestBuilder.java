package Task_11;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.valueObject.LoginPage;
import pageObjects.saucedemo.valueObject.LoginPageBuilder;
import pageObjects.saucedemo.valueObject.ProductPage;

public class LoginTestBuilder extends BaseTest {

    String url = "https://www.saucedemo.com/";
    @Test
    public void test1() {
        LoginPageBuilder loginPageBuilder = new LoginPageBuilder
                .Builder()
                .withUserName("standard_user")
                .withPassword("secret_sauce")
                .build();
        new LoginPage()
                .open(url)
                .enterData(loginPageBuilder)
                .clickLogin();
        new ProductPage()
                .verifyPageTitle();
    }
}