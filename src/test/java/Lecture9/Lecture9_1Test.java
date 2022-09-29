package Lecture9;

import org.testng.Reporter;
import org.testng.annotations.*;

public class Lecture9_1Test {

    @BeforeTest(groups = "test9")
    public void beforeTest(){
        System.out.println("beforeTest");
    }
    @BeforeMethod(groups = {"test9new", "test9"})
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }
    @BeforeClass(groups = "test9")
    public void beforeclass(){
        System.out.println("BeforeClass");
    }
    @BeforeSuite(groups = "test9")
    public void BeforeSuite(){
        System.out.println("BeforeSuite");
    }
    @BeforeGroups(groups = "test9")
    public void BeforeGroup(){
        System.out.println("BeforeGroups");
    }
    @Test(groups = "test9")
    public void test1(){

        System.out.println("1 test");
    }
    @Test(groups = "test9new")
    public void test2(){
        System.out.println("test 2");
    }
    @AfterTest(groups = "test9")
    public void AfterTest(){
        System.out.println("AfterTest");
    }
    @AfterSuite(groups = "test9")
    public void AfterSuite(){
        System.out.println("AfterSuite");
    }
    @AfterGroups(groups = "test9")
    public void AfterGroups(){
        System.out.println("AfterGroups");
    }
    @AfterMethod(groups = {"test9new", "test9"})
    public void AfterMethod(){
        System.out.println("AfterMethod");
    }
    @AfterClass(groups = "test9")
    public void AfterClass() {
        System.out.println("AfterClass");

    }
}
