package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;
import static driver.SimpleDriver.*;

public class DropdownListPage extends BasePage {

    private By title = By.xpath("//h3[text()]");

    private By selectOption1Index = By.xpath("//option[@value='1']");
    private By selectOption2Index = By.xpath("//option[@value='2']");

    private By SelectOption1Name = By.xpath("//option[text()='Option 1']");
    private By SelectOption2Name = By.xpath("//option[text()='Option 2']");

    private By select = By.id("dropdown");

    Select selector = new Select(getWebDriver().findElement(select));

    public DropdownListPage isDisplayedPage() {
        Assert.assertEquals(driver.findElement(title).getText(), "Dropdown List");
        System.out.println("Open page with text: Dropdown List");
        return this;
    }

    public DropdownListPage selectOptions(int index){
        selector.selectByIndex(index);
        return this;
    }

    public DropdownListPage selectOptions(String value){
        selector.selectByVisibleText(value);
        return this;
    }

    public DropdownListPage selectByIndexIsDisplayed(String value){
        selector.selectByValue(value);
        return this;
    }

    public DropdownListPage select1IsDisplayed(){
        System.out.println("select 1 is displayed");
        isDisplayed(selectOption1Index);
        return this;
    }

    public DropdownListPage select2IsDisplayed(){
        System.out.println("select 2 is displayed");
        isDisplayed(selectOption2Index);
        return this;
    }

    public DropdownListPage select1ValueIsDisplayed(){
        System.out.println("select 1 from text value is displayed");
        isDisplayed(SelectOption1Name);
        return this;
    }

    public DropdownListPage select2ValueIsDisplayed(){
        System.out.println("select 2 from text value is displayed");
        isDisplayed(SelectOption2Name);
        return this;
    }
}
