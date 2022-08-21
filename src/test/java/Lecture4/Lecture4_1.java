package Lecture4;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lecture4_1 {
    /*
    На вход дается число.
    Если число кратно 3 - возвращается T,
    если кратно 5, то M,
    а если 15 то S.
     */
    @Test
    public void test1(){
        Assert.assertEquals(getData(3),"T","");
    }
    @Test
    public void test2(){
        Assert.assertEquals(getData(5),"M","");
    }
    @Test
    public void test3(){
        Assert.assertEquals(getData(15),"S","");
    }
    @Test
    public void test4(){ //проверка кратности всех остальных значений, возвращаем пустую строку в гетДата, поэтому expected = ""
        Assert.assertEquals(getData(16),"");
    }
    @Test
    public void test5(){
        Assert.assertTrue(getData(11).isEmpty());
    }
    private String getData(int value){
        if(value % 3 == 0 && value % 15 != 0){
            return "T";
        } else if (value % 5 == 0 && value % 15 != 0){
            return "M";
        } else if(value % 15 == 0){
            return "S";
        }
        return "";
    }
}
