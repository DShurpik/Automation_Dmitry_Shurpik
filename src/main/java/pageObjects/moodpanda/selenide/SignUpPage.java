package pageObjects.moodpanda.selenide;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

@Log4j
@Data

public class SignUpPage {

    private SelenideElement firstNameField = $(xpath("//input[@placeholder='Your first name']"));
    private SelenideElement lastNameInitialField = $(xpath("//input[@maxlength='1']"));
    private SelenideElement emailField = $(xpath("//input[@placeholder='Your email address']"));
    private SelenideElement passwordField = $(xpath("//input[@name='password']"));
    private SelenideElement checkbox = $(xpath("//input[@type='checkbox']"));
    private SelenideElement signUpBtn = $(xpath("//button"));
    private SelenideElement alertMessage = $(xpath("//div[contains(text(),'We will send')]"));
    private SelenideElement yesSignMeUpBtn = $(xpath("//button//span[text()='Yes. Sign me up']"));
    private SelenideElement verifyMessage = $(xpath("//div[@class='mesdsage-body']//p[@class='block']"));
    private SelenideElement logOutBtn = $(xpath("//a[@class='button is-ligdht is- is-outlined is-rounded']"));

    private String firstName;
    private String lastNameInitial;
    private String email;
    private String password;


    public SignUpPage enterFirstName(String firstName) {
        log.debug("Enter: " + firstName);
        this.firstNameField.sendKeys(firstName);
        return this;
    }

    public SignUpPage enterLastNameInitial(String initial) {
        log.debug("Enter: " + initial);
        this.lastNameInitialField.sendKeys(initial);
        return this;
    }

    public SignUpPage enterEmail(String email) {
        log.debug("Enter: " + email);
        this.emailField.sendKeys(email);
        return this;
    }

    public SignUpPage enterPassword(String password) {
        log.debug("Enter: " + password);
        this.passwordField.sendKeys(password);
        return this;
    }

    public SignUpPage clickCheckBox() {
        log.debug("Click: " + checkbox);
        this.checkbox.click();
        return this;
    }

    public SignUpPage clickSignUpBtn() {
        log.debug("Click: " + signUpBtn);
        this.signUpBtn.click();
        return this;
    }

    public SignUpPage alertMessageIsDisplayed() {
        log.debug("Is displayed: " + alertMessage);
        this.alertMessage.should(enabled);
        return this;
    }

    public SignUpPage clickYesSignMeUpBtn() {
        log.debug("Click: " + yesSignMeUpBtn);
        this.yesSignMeUpBtn.click();
        return this;
    }

    public SignUpPage verify() {
        log.debug("We've emailed you a verification code Is displayed");
        verifyMessage.should(enabled);
        return this;
    }

    public SignUpPage enterData(SignUpPage signUpPage) { // Для value object
        enterFirstName(signUpPage.getFirstName());
        enterLastNameInitial(signUpPage.getLastNameInitial());
        enterEmail(signUpPage.getEmail());
        enterPassword(signUpPage.getPassword());
        return this;
    }

    public SignUpPage enterData(SignUpPageBuilder signUpPageBuilder){
        enterFirstName(signUpPageBuilder.firstName);
        enterLastNameInitial(signUpPageBuilder.lastNameInitial);
        enterEmail(signUpPageBuilder.email);
        enterPassword(signUpPageBuilder.password);
        return this;
    }

    public SignUpPage equalText(String firstName){
        String [] str = logOutBtn.getText().split(" ");
        Assert.assertEquals(str[1], firstName);
        log.debug("Name equal name in Logout button");
        return this;
    }
}
