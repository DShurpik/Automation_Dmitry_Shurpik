package testNgUtils;

import lombok.extern.log4j.Log4j;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import propertyHelper.PropertyReader;

@Log4j

public class Listener implements ITestListener { // Listener для реализации TestNG

    @Override
    public void onStart(ITestContext context){
        // на уровне старта тестов создаем propertyreadeer, и передаем название ресурса из паки ресурсы
        // используем тернарный оператор для проверки условий
        String propertyName = context.getSuite().getParameter("config") == null ? System.getProperty("config") : context.getSuite().getParameter("config");

        new PropertyReader(propertyName);
        log.debug("Property: " + propertyName);
    }
    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.log("this was failed =>" + result.getName());
    }

    @Override
    public void onFinish(ITestContext context){
        Reporter.log(context.getSuite().getXmlSuite().getTest());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        Reporter.log("this was failed =>" + result.getName());
    }
}
