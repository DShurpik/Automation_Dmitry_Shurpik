package Lecture19;

import Lecture19.entity.Person;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class test {

    @Test(enabled = false)
    public void jsontest(){

        Gson gson = new Gson();
        String data = getJson();
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        System.out.println(gson.toJson(jsonObject));
        System.out.println(jsonObject.get("id").getAsInt()); // json element
        System.out.println(jsonObject.get("name").getAsString());  // json element
        System.out.println(jsonObject.get("cars").getAsJsonArray().get(0).getAsString());

        System.out.println(gson.fromJson(jsonObject.get("cars"), List.class));
        System.out.println(gson.fromJson(jsonObject, Map.class));

        System.out.println(jsonObject.get("wife").getAsJsonObject().get("name"));
        System.out.println(jsonObject.get("children").getAsJsonArray().get(0).getAsJsonObject().get("name"));




        //System.out.println(getJson());

    }


    @Test
    public void testJson2(){
        Gson gson = new Gson();
        String data = getJson();
        Person person = gson.fromJson(data, Person.class);
        person.getCars().forEach(System.out::println);
        person.getChildren().forEach(children -> System.out.println(children.getName()));
    }

    public String getJson(){
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/resources/person.json")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
