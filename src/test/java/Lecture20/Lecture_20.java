package Lecture20;


import Lecture20.entity.request.User_request;
import Lecture20.entity.responce.User_responce;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Lecture_20 {

    @BeforeTest
    public void precondition() {
        baseURI = "https://reqres.in/api";
    }

    @Test
    public void get_test(){
        Response response = given().get("/users?id=2");
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(response.then().extract().response().jsonPath().getInt("data.id"), 2);
    }

    @Test
    public void post_test1() {
        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        Response response = given().header("Content-Type", "application/json").body(body).post("/users");
        response.then().assertThat().statusCode(201);
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("name"), "morpheus");
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("job"), "leader");
    }

    @Test
    public void post_test2() {                                                          // происходит передача файла из папки, тут пишем только имя файла
        Response response = given().header("Content-Type", "application/json").body(getJson("lecture20")).post("/users");
        response.then().assertThat().statusCode(201);
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("name"), "morpheus");
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("job"), "leader");
    }

    @Test
    public void post_test3(){
        // используем pojo объекты
        User_request user_request = new User_request(){{
            setName("morpheus");
            setJob("leader");
        }};
        Response response = given().header("Content-Type", "application/json").body(user_request).post("/users");
        response.then().assertThat().statusCode(201);
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("name"), "morpheus");
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("job"), "leader");
    }

    @Test
    public void post_test4(){
        // используем pojo объекты
        User_request user_request = new User_request(){{
            setName("morpheus");
            setJob("leader");
        }};
        Response response = given().header("Content-Type", "application/json").body(user_request).post("/users");
        response.then().assertThat().statusCode(201);
        User_responce user_responce = response.as(User_responce.class);
        Assert.assertEquals(user_responce.getName(), user_request.getName());
        Assert.assertEquals(user_responce.getJob(), user_request.getJob());
    }

    // контрактное тестирование json
    @Test
    public void test5(){}

    public String getJson(String fileName){
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/resources/" + fileName + ".json")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
