package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class UsersClient {

    public Response createUser(String body) {

        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer ")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v1/users");

    }
}
