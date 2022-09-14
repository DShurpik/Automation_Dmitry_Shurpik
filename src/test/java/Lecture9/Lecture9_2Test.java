package Lecture9;

import org.testng.annotations.Test;
import testNgUtils.Retry;

public class Lecture9_2Test {

    int count = 1;
    int timeout = 4;
    @Test(enabled = false, priority = 1)
    public void test1(){
        System.out.println("test1");
    }
    @Test(enabled = true, priority = 2)
    public void test2(){
        System.out.println("test2");
    }
    @Test(timeOut = 1000, description = "test 3 from lecture 3", priority = 3)
    public void test3() throws InterruptedException {
        pause(2);
        System.out.println("test3");
    }
    @Test(dependsOnMethods = "test3", priority = 4)
    public void test4() throws InterruptedException {
        pause(2);
        System.out.println("test4");
    }
    @Test(invocationCount = 5, threadPoolSize = 5, priority = 5)
    public void test5(){
        pause(2);
        System.out.println("test5 # " + count++);
    }
    @Test(timeOut = 1000, priority = 6, retryAnalyzer = Retry.class)
    public void test6(){
        pause(timeout--);
        System.out.println("test6 " + timeout);
    }
    public void pause(long timeout)  {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

