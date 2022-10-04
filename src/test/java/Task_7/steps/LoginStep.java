package Task_7.steps;

import pageObjects.baseObjects.BasePage;
import pageObjects.saucedemo.LoginPage;

public class LoginStep extends BasePage {

    LoginPage loginPage = new LoginPage();

    public LoginStep login(String username, String password) {
        loginPage.open().enterUsername(username).enterPassword(password).clickLogin();
        return this;
    }
}
