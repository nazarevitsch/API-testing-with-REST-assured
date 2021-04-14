import entities.Login;
import entities.Token;
import org.junit.Test;

import io.restassured.response.Response;

public class LoginTest {

    @Test
    public void loginWithValidData() {
        Login login = new Login();
        login.setUsername("test@gmail.com");
        login.setPassword("Test2021");
        Response r = new ApiEndpoints().loginUser(login);
        r.then().statusCode(200);
    }

    @Test
    public void loginWithInvalidData() {
        Login login = new Login();
        login.setUsername("test@gmail.com");
        login.setPassword("Nazar2021");
        Response r = new ApiEndpoints().loginUser(login);
        r.then().statusCode(406);
    }
}
