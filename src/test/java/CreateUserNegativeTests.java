
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

public class CreateUserNegativeTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test
    public void shouldNotAllowUserToCreateWithInvalidEmail() {
        // 1.Arrange
        String body = "{\"name\":\"Vivek\", \"gender\":\"male\", \"email\":\"vi1v1ekk111vhpatelil.c11om\", \"status\":\"active\"}";

        //Act
      usersClient.createUser(body)
                .then()
                .log().body()

                //Assert
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("data", Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }

}
