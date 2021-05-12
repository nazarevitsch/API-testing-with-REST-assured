import entities.Login;
import entities.Token;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;

import io.restassured.response.Response;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class LoginTest {

    @Test
    public void loginWithValidData() {
        Login login = new Login();
        login.setUsername("test@gmail.com");
        login.setPassword("Test2021");
        Response response = new ApiEndpoints().loginUser(login);
        response.then().statusCode(200);
    }

    @Test
    public void loginWithInvalidData() {
        Login login = new Login();
        login.setUsername("test@gmail.com");
        login.setPassword("Nazar2021");
        Response response = new ApiEndpoints().loginUser(login);
        response.then().statusCode(406);
    }
}
