package PageObject.saucedemo;

import PageObject.BaseObject.BasePage;
import org.openqa.selenium.By;
import static Driver.SimpleDriver.getWebDriver;

public class LoginPage extends BasePage {
    // НАшли элементы на странице
    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");

    public LoginPage open() {
        getWebDriver().get("https://www.saucedemo.com/");
        return this;
    }

    public LoginPage enterUsername(String username) {
        enter(this.username, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        enter(this.password, password);
        return this;
    }

    public LoginPage clickLogin() {
        click(loginBtn);
        return this;
    }
}
