package Task_11;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.SauceDemo.LoginPage;

import pageFactory.SauceDemo.ProductPage;
import pageObjects.baseObjects.BaseTest;

public class LoginTestPageFactory extends BaseTest {

    //@Parameters({"url", "userName", "password"})
    @Test
    public void test1(){
        new LoginPage()
                .open(properties.getProperty("url"))
                .entertUserName(properties.getProperty("username"))
                .enterPassword(properties.getProperty("password"))
                .clickLoginBtn();
        new ProductPage()
                .titleIsDisplayed();
    }
}