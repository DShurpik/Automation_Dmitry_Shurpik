package Lecture18;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

// CucumberOptions отвечает за связку features и steps

@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {
                "json:target/cucumber.json", // плагин для отчетов
                "html:target/site/cucumber-pretty"
        },
        glue = "cucumberSteps/moodPanda")

public class RunMoodPandaCucumber extends AbstractTestNGCucumberTests {

    // наследуемся от кукумбертест, и переопределяем метод из класса для того чтобы определить какие сценарии используем в тестах

    @DataProvider
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }

}

