package pageObjects.herokuapp;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

public class DynamicControlsPage extends BasePage {

    private By checkBox = By.xpath("//input[@type='checkbox']");
    private By removeBtn = By.xpath("//button[text()='Remove']");
    private By inscription = By.id("message");
    private By inputDisable = By.xpath("//input[@type='text' and 'disabled']");
    private By inputEnable = By.xpath("//p[@id='message']");
    private By inputBtn = By.xpath("//button[text()='Enable']");
    private By inputText = By.xpath("//input[@type='text']");

    public void navigateTo(NavigationItems navigationItems){
        click(getByLink(navigationItems.getItem()));
    }

    public By getByLink(String textLink){
        return By.partialLinkText(textLink);
    }

    public DynamicControlsPage open(){
        driver.get("http://the-internet.herokuapp.com/");
        return this;
    }
    public DynamicControlsPage clickCheckBox(){
        click(checkBox);
        return this;
    }
    public DynamicControlsPage isEnableCheckBox(){
        isDisplayed(checkBox);
        return this;
    }
    public DynamicControlsPage clickRemoveBtn(){
        click(removeBtn);
        return this;
    }
    public DynamicControlsPage inscriptionIsEnable(){
        isDisplayed(inscription);
        return this;
    }
    public DynamicControlsPage inputDisable(){
        isDisplayed(inputDisable);
        return this;
    }
    public DynamicControlsPage clickEnableBtn(){
        click(inputBtn);
        return this;
    }
    public DynamicControlsPage inputTextEnable(){
        isDisable(inputEnable);
        return this;
    }
    public DynamicControlsPage sendTextInInput(String text){
        enter(inputText, text);
        return this;
    }

}
