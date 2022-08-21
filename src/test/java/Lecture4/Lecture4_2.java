package Lecture4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Lecture4_2 {



    @Test
    public void test1(){
        // Установка системной переменной хром драйвер
        System.setProperty("webdriver.chrome.driver","src/test/java/resources/chromedriver.exe");
        // Создание локальной переменной WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // открытие ссылки методом .get
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        // поиск по типу name By.name
        WebElement zipCode = driver.findElement(By.name("zip_code"));
        // кликаем по элементу
        zipCode.click();
        // вводим значения 1111 в поле зипкод
        zipCode.sendKeys("1111");
        // создаем элемент кнопки continue
        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue' ]"));
        // кликаем по continue
        continueButton.click();
    }
    public void test2(){
        System.setProperty("webdriver.chrome.driver","src/test/java/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        WebElement zipCode = driver.findElement(By.name("zip_code"));
        zipCode.click();
        zipCode.sendKeys("11111");
        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue' ]"));
        continueButton.click();
    }



}
