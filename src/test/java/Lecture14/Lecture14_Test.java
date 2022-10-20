package Lecture14;

import Lecture14.entity.Car;
import Lecture14.entity.Home;
import Lecture14.entity.HomeBuilderLombok;
import Lecture14.entity.Person;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.Test;

@Log4j // аннотация для логгирования

public class Lecture14_Test {

    @Test
    public void person_Test(){
        Person person = new Person() {{
            setAddress("Postavy");
            setFirstName("Dmitry");
            setLastName("Shurpik");
        }};

        log.debug(person);
        Person person1 = new Person("", "", "", 0, "", "");
        log.debug(person1);
    }

    @Test
    public void car_test(){
        Car car = new Car(){{
           setColor("black");
           setModel("tesla");
           setType("electro");
        }};
        log.debug(car.getYear());
        log.debug(car);
    }

    @Test
    public void home_test(){
        Home home = new Home.Builder().withAddress("Postavy").withWinCount(5).build();
        log.debug(home);

    }

    @Test
    public void home_test_from_lombok(){
        HomeBuilderLombok homeBuilderLombok = new HomeBuilderLombok.HomeBuilder().withAddress("Postavy").withWinCount(5).create();
        log.debug(homeBuilderLombok);
    }
}