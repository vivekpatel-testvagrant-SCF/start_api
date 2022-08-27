package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.create.CreateUserRequest;

import static io.restassured.RestAssured.given;
public class UsersClient {

    public Response createUser(CreateUserRequest body) {

        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer 3f19f08e5ec0a3ee893e574b47b5111dc93665012b526172e1f584b2d034eae6")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v1/users");

    }

    public Response getAllUsers() {
        return given()
                .when()
                .get("https://gorest.co.in/public/v2/users/3");
    }
}
