package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;


public class LoginPage extends BasePage {
    // НАшли элементы на странице
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-button");

    private final By error = By.xpath("//div[@class][h3]");

    private final By errorLockedUser = By.xpath("//button[@class]");

    public LoginPage open() {
        load();
        return this;
    }
    public LoginPage open(String url) {
        driver.get(url);
        return this;
    }

    public LoginPage enterUsername(String username) {
        enter(this.username, username);
        return this;
    }

    public LoginPage enterUsername() {
        enter(this.username, properties.getProperty("username"));
        return this;
    }

    public LoginPage userName (String userName){
        enter(this.username,System.getProperty(userName));
        return this;
    }
    public LoginPage userPassword (String passwordUser){
        enter(this.password, System.getProperty(passwordUser));
        return this;
    }

    public LoginPage enterPassword(String password) {
        enter(this.password, password);
        return this;
    }

    public LoginPage enterPassword() {
        enter(this.password, properties.getProperty("password"));
        return this;
    }

    public LoginPage verifyThatLoginPageIsClosed(){
        Assert.assertTrue(elementNotExist(loginBtn));
        return this;
    }

    public LoginPage verifyError(){
        Assert.assertTrue(elementNotExist(error));
        return this;
    }

    public LoginPage errorLockedUserIsDisplayed(){
        Assert.assertEquals(getText(errorLockedUser), "Epic sadface: Sorry, this user has been locked out.");
        return this;
    }

    public LoginPage clickLogin() {
        click(loginBtn);
        return this;
    }
}
