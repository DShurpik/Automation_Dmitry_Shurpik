package pageObjects.herokuapp;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

public class DynamicControlsPage extends BasePage {

    private By checkBox = By.xpath("//input[@type='checkbox']");
    private By removeBtn = By.xpath("//button[text()='Remove']");
    private By inscription = By.id("message");
    private By input = By.xpath("//input[@type='text']");
    private By inputBtn = By.xpath("//button[text()='Enable']");

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
        isEnable(checkBox);
        return this;
    }
    public DynamicControlsPage clickRemoveBtn(){
        click(removeBtn);
        return this;
    }
    public DynamicControlsPage inscriptionIsEnable(){
        isEnable(inscription);
        return this;
    }

}
