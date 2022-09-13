package PageObjectForTask7.sauceDemo;

import org.openqa.selenium.By;
import static driver.SimpleDriver.getWebDriver;

public class LoginPage {

    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");
    By errorFieldIsEmpty = By.xpath("//div[@class='error-message-container error']");
    By errorLockedUser = By.xpath("//div[@class='error-message-container error']");

    public void open(){
        getWebDriver().get("https://www.saucedemo.com/");
    }

    public void sendUserName(String username){
        getWebDriver().findElement(this.username).sendKeys(username);
    }
    public void sendPassword(String password){
        getWebDriver().findElement(this.password).sendKeys(password);
    }
    public void clickLoginBtn(){
        getWebDriver().findElement(loginBtn).click();
    }
    public void errorFieldIsEmptyIsDisplayed(){
        System.out.println("Epic sadface: You can only access '/inventory-item.html' when you are logged in.");
        getWebDriver().findElement(errorFieldIsEmpty).isDisplayed();
    }
    public void errorLockedUserIsDisplayed(){
        System.out.println("Epic sadface: Sorry, this user has been locked out.");
        getWebDriver().findElement(errorLockedUser);
    }
}
