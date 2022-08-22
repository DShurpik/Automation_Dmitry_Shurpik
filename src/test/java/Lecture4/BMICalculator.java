package Lecture4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BMICalculator {

    @Test
    public void test(){
       WebDriver chromeDriver = new ChromeDriver();
       chromeDriver.get("https://healthunify.com/bmicalculator/");
       WebElement setWeight = chromeDriver.findElement(By.name("wg"));
       WebElement setHeight = chromeDriver.findElement(By.name("ht"));
       //WebElement result = chromeDriver.findElement(By.xpath("//article[@id='post-556']/div/div/form/table[2]/tbody/tr/td/input"));

       WebElement si = chromeDriver.findElement(By.name("si"));
       WebElement calculate = chromeDriver.findElement(By.name("cc"));
       setWeight.sendKeys("80");
       setHeight.sendKeys("90");
       calculate.click();
       WebElement updSi = chromeDriver.findElement(By.name("si"));
       String s = "21";
       updSi.click();





    }
}
