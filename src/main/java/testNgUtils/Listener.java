package testNgUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener implements ITestListener { // Listener для реализации TestNG

    @Override
    public void onStart(ITestContext context){
        Reporter.log(context.getSuite().getXmlSuite().getTest());
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
