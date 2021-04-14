import entities.Registration;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

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

    @Test
    public void registerUserWithAlreadyUserEmailWaitMessageError() {
        Registration registration = new Registration();
        registration.setUsername("test@gmail.com");
        registration.setPassword("Test2021");
        registration.setName("Test");
        Response response = new ApiEndpoints().registrationUser(registration);
        Error error = response.body().as(Error.class);
        Assert.assertEquals("Email is already used.", error.getMessage());
    }
}
