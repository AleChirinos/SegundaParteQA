package basicRestAssure.item;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class RestAssuredItem {
    @Test
    public void  createProject(){
        given()
                .auth()
                .preemptive()
                .basic("upb_api@api.com","12345")
                .body("{\n" +
                        "  \"Content\":\"AlejandraRestAssuredItem\",\n" +
                        "}")
                .log().all()
                .when()
                .post("https://todo.ly/api/items.json")
                .then()
                .log().all();
    }

    @Test
    public void  createProjectaJSONObject(){

        JSONObject body = new JSONObject();
        body.put("Content","AlejandraJSONItem");

        given()
                .auth()
                .preemptive()
                .basic("upb_api@api.com","12345")
                .body(body.toString())
                .log().all()
                .when()
                .post("https://todo.ly/api/items.json")
                .then()
                .log().all();
    }

    @Test
    public void  createProjectaExternalFile(){
        String pathProject=new File("").getAbsolutePath();

        given()
                .auth()
                .preemptive()
                .basic("upb_api@api.com","12345")
                .body(new File(pathProject+"/src/test/resources/itemBody.json"))
                .log().all()
                .when()
                .post("https://todo.ly/api/items.json")
                .then()
                .log().all();
    }
}
