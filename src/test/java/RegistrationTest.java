import entities.Registration;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SerenityRunner.class)
public class RegistrationTest {

    @Test
    public void registerUserWithAlreadyUserEmailWaitCode406() {
        Registration registration = new Registration();
        registration.setUsername("test@gmail.com");
        registration.setPassword("Test2021");
        registration.setName("Test");
        Response response = new ApiEndpoints().registrationUser(registration);
        response.then().statusCode(406);
    }

}
