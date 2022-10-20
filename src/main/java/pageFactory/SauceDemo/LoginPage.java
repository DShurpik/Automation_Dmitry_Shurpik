package pageFactory.SauceDemo;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.baseObjects.BasePage;
@Log4j

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public LoginPage entertUserName(String name){
        enter(this.userName, name);
        return this;
    }

    public LoginPage enterPassword(String password){
        enter(this.password, password);
        return this;
    }

    public LoginPage clickLoginBtn(){
        click(this.loginBtn);
        return this;
    }

    public LoginPage open(String url) {
        load(url);
        return this;
    }
}
