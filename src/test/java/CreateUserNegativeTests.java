import Users.UsersClient;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class CreateUserNegativeTests {

    @Test
    public void shouldNotAllowUserToCreateWithInvalidEmail() {
        // 1.Arrange
        String body = "{\"name\":\"Vivek\", \"gender\":\"male\", \"email\":\"vi1v1ekk111vhpatelil.c11om\", \"status\":\"active\"}";

        //Act
       new UsersClient().createUser(body)
                .then()
                .log().body()

                //Assert
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("data", Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }

}
