package pageObjects.MoodPanda;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

public class NavigationPage extends BasePage {

    private By signUpBtn = By.partialLinkText("Sign Up");

    public NavigationPage clickSignUp(){
        click(signUpBtn);
        return this;
    }

}
