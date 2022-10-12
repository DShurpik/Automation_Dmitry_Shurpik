package pageObjects.saucedemo.valueObject;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

public class LoginPage extends BasePage {

    private By userNameField = By.id("user-name");
    private By passwordField = By.id("password");

    private final By loginBtn = By.id("login-button");

    private String userName;
    private String password;
    private String url;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LoginPage enterUsername(String userName) {
        enter(this.userNameField, userName);
        return this;
    }

    public LoginPage enterPassword(String password) {
        enter(this.passwordField, password);
        return this;
    }

    public LoginPage enterData(String firstName, String lastName) { // метод в котором все методы необходимые для ввода
        enterUsername(firstName);
        enterPassword(lastName);
        return this;
    }

    public LoginPage enterData(LoginPage loginPage) { // метод в котором все методы необходимые для ввода
        enterUsername(loginPage.getUserName());
        enterPassword(loginPage.getPassword());
        return this;
    }

    public LoginPage enterData(LoginPageBuilder loginPageBuilder){
        enterUsername(loginPageBuilder.userName);
        enterPassword(loginPageBuilder.password);
        return this;
    }

    public LoginPage clickLogin() {
        click(loginBtn);
        return this;
    }

    public LoginPage open(String url) {
        load(url);
        return this;
    }
}
