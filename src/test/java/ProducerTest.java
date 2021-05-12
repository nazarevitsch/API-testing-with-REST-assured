import entities.Login;
import entities.Producer;
import entities.Token;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class ProducerTest {

    @Test
    public void createProducerByLoginUserStatusCode() {
        Login login = new Login();
        login.setUsername("test@gmail.com");
        login.setPassword("Test2021");
        Producer producer = new Producer().setImage("undefined").setNew_image("false").setProducer_name("Test producer")
                .setTypes("1").setSteps("1").setRegion_id("1").setDescription("Test test test test test");
        Response response = new ApiEndpoints().addProducer(producer, new ApiEndpoints().loginUser(login).body().as(Token.class).getToken());
        response.then().statusCode(200);
    }

    @Test
    public void createProducerByUnLoginUserStatusCode() {
        Producer producer = new Producer().setImage("undefined").setNew_image("false").setProducer_name("Test producer")
                .setTypes("1").setSteps("1").setRegion_id("1").setDescription("Test test test test test");
        Response response = new ApiEndpoints().addProducer(producer, "");
        response.then().statusCode(401);
    }

    @Test
    public void updateProducerByLoginUserStatusCode() {
        Login login = new Login();
        login.setUsername("test@gmail.com");
        login.setPassword("Test2021");
        Producer producer = new Producer().setImage("undefined").setNew_image("false").setProducer_name("Test producer")
                .setTypes("1").setSteps("1").setRegion_id("1").setDescription("Test test test test test");
        Response response = new ApiEndpoints().updateProducer(producer, new ApiEndpoints().loginUser(login).body().as(Token.class).getToken());
        response.then().statusCode(200);
    }


    @Test
    public void deleteProducerStatusCode() {
        Login login = new Login();
        login.setUsername("test@gmail.com");
        login.setPassword("Test2021");
        Response response = new ApiEndpoints().deleteProducer(new ApiEndpoints().loginUser(login).body().as(Token.class).getToken());
        response.then().statusCode(200);
    }

    @Test
    public void getProducerByRealId() {
        Response response = new ApiEndpoints().getProducerById(5);
        response.then().statusCode(200);
    }

    @Test
    public void getProducerByUnrealId() {
        Response response = new ApiEndpoints().getProducerById(6);
        response.then().statusCode(200);
    }
}
