package basicRestAssure.project;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CRUDProject {
    @Test
    public void crudProject(){
        // Create
        JSONObject body = new JSONObject();
        body.put("Content","AlejandraJSON2");
        body.put("Icon",1);

        Response response=given()
                .auth()
                .preemptive()
                .basic("upb_api@api.com","12345")
                .body(body.toString())
                .log().all()
                .when()
                .post("https://todo.ly/api/projects.json");

        response.then()
                .statusCode(200)
                .body("Content",equalTo("AlejandraJSON2"))
                .body("Icon",equalTo(1))
                .log().all();

        int idProject =response.then().extract().path("Id");


        // Read
        response=given()
                .auth()
                .preemptive()
                .basic("upb_api@api.com","12345")
                .log().all()
                .when()
                .get("https://todo.ly/api/projects/"+idProject+".json");

        response.then()
                .statusCode(200)
                .body("Content",equalTo("AlejandraJSON2"))
                .body("Icon",equalTo(1))
                .log().all();
        // Update
        body.put("Content","AlejandraUpdate");
        response=given()
                .auth()
                .preemptive()
                .basic("upb_api@api.com","12345")
                .body(body.toString())
                .log().all()
                .when()
                .put("https://todo.ly/api/projects/"+idProject+".json");

        response.then()
                .statusCode(200)
                .body("Content",equalTo("AlejandraUpdate"))
                .body("Icon",equalTo(1))
                .log().all();
        // Delete
        response=given()
                .auth()
                .preemptive()
                .basic("upb_api@api.com","12345")
                .log().all()
                .when()
                .delete("https://todo.ly/api/projects/"+idProject+".json");

        response.then()
                .statusCode(200)
                .body("Content",equalTo("AlejandraUpdate"))
                .body("Icon",equalTo(1))
                .body("Deleted",equalTo(true))
                .log().all();
    }
}

