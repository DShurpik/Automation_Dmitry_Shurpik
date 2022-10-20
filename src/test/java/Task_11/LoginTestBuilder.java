package Task_11;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.valueObject.LoginPage;
import pageObjects.saucedemo.valueObject.LoginPageBuilder;
import pageObjects.saucedemo.valueObject.ProductPage;

public class LoginTestBuilder extends BaseTest {

    @Parameters({"url", "userName", "password"})
    @Test
    public void test1(String url, String userName, String password) {
        LoginPageBuilder loginPageBuilder = new LoginPageBuilder
                .Builder()
                .withUserName(userName)
                .withPassword(password)
                .build();
        new LoginPage()
                .open(url)
                .enterData(loginPageBuilder)
                .clickLogin();
        new ProductPage()
                .verifyPageTitle();
    }
}