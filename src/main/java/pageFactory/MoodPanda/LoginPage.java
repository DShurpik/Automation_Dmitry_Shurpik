package pageFactory.MoodPanda;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class LoginPage extends BasePage {

   @FindBy(how = How.CSS, using = "[type='text']")
    WebElement email;

   @FindBy(css = "[type = 'password']")
   WebElement password;

   @FindBy(xpath = "//button[@class]")
   WebElement loginBtn;

   @FindBy(css = "[role='alert']")
   WebElement alert;

   public LoginPage(){  // конструктор класса
       PageFactory.initElements(driver, this); // инициализация элементов, на вход драйвер и ссылку на объект этого класса
   }


   public LoginPage enterPassword(String password){
       enter(this.password, password);
       return this;
   }

    public LoginPage enterEmail(String email){
       enter(this.email, email);
       return this;
    }

    public LoginPage clickLogin(){
       click(loginBtn);
       return this;
    }

    public LoginPage verifyAlertMsg(String message){
       Assert.assertEquals(getText(alert), message);
       return this;
    }

}
