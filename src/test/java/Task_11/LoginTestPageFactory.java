package Task_11;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.SauceDemo.LoginPage;

import pageFactory.SauceDemo.ProductPage;
import pageObjects.baseObjects.BaseTest;

public class LoginTestPageFactory extends BaseTest {

    @Parameters({"url", "userName", "password"})
    @Test
    public void test1(String url, String userName, String password){
        new LoginPage()
                .open(url)
                .entertUserName(userName)
                .enterPassword(password)
                .clickLoginBtn();
        new ProductPage()
                .titleIsDisplayed();
    }
}