package Lecture4;


import driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

import static driver.SimpleDriver.getWebDriver;

public class Lecture4_3HomeWorkGoogleBy {


    @Test
    public void test1(){  // проверка что после поиска в гугл.бай в строке поиска остается текст "Привет, мир"
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://www.google.by/");
        getWebDriver().findElement(By.name("q")).sendKeys("Привет, мир", Keys.ENTER);
        List<WebElement> results = getWebDriver().findElements(By.cssSelector("[lang='ru'] h3"));
        for (WebElement element : results) {
            Assert.assertTrue(element.getText().contains("Мир"));
        }
    }
}
