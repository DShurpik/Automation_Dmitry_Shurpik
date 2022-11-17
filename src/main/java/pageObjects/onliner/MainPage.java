package pageObjects.onliner;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.baseObjects.BasePage;

@Log4j

public class MainPage extends BasePage {

    private WebElement searchField = driver.findElement(By.xpath("//input[@class='fast-search__input']"));
    private WebElement searchBtn = driver.findElement(By.className("btn btn-search"));

    public MainPage open(String url){
        load(url);
        return this;
    }

    public MainPage sendTest(String text){
        enter(searchField,text );
        return this;
    }

    public MainPage clickOnSearch(){
        searchBtn.click();
        return this;
    }

}
