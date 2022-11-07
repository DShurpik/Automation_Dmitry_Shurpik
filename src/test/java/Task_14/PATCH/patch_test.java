package Task_14.PATCH;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class patch_test {

    @BeforeTest
    public void precondition() {
        baseURI = "https://reqres.in/api";
    }

    @Test
    public void patch_test2(){
        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";
        Response response = given().header("Content-Type", "application/json").body(body).patch("/users/2");
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("name"), "morpheus");
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("job"), "QpwL5tke4Pnpja7X4");
    }

}
