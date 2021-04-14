import entities.Login;

import entities.Producer;
import entities.Registration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiEndpoints {

    public Response loginUser(Login login) {
        return given().
                body(login).
                post(ConfigPath.LOGIN_ENDPOINT).
                then().extract().response();
    }

    public Response registrationUser(Registration registration) {
        return given().
                body(registration).
                post(ConfigPath.REGISTER_ENDPOINT).
                then().extract().response();
    }

    public Response addProducer(Producer producer, String token) {
        System.out.println(token);
        return given().
                body(producer)
                .cookie("token", token).
                post(ConfigPath.MANAGE_PRODUCER).
                then().extract().response();
    }

    public Response updateProducer(Producer producer, String token) {
        System.out.println(token);
        return given().
                body(producer)
                .cookie("token", token).
                        put(ConfigPath.MANAGE_PRODUCER).
                        then().extract().response();
    }

    public Response deleteProducer(String token) {
        System.out.println(token);
        return given()
                .cookie("token", token).
                        body("").
                        delete(ConfigPath.MANAGE_PRODUCER).
                        then().extract().response();
    }

    public Response getProducerById(long id){
        return given().pathParam("producerID", id)
                .get(ConfigPath.PRODUCER).then().extract().response();
    }

    private RequestSpecification given() {
        return RestAssured.given()
                .log().uri()
                .log().body()
                .baseUri(ConfigPath.BASE_URL)
                .contentType(ContentType.JSON);
    }
}
