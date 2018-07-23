package ApiTests;

import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static ApiTests.helpers.InitializationTestHelper.initialize;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParameterCountry_ItunesApiTest {

    @BeforeClass
    public static void setup() {
        initialize(8080, "/search?term=jack+johnson", "https://itunes.apple.com");
    }

    @Test
    public void ParameterCountry1_ItunesApiTest() {
        given().when().get("/search?term=Better&country=US").then().statusCode(200);
    }

    @Test
    public void ParameterCountry2_ItunesApiTest() {
        given().when().get("/search?term=Better&country=XX").then().statusCode(400);
    }

    @Test
    public void ParameterCountry3_ItunesApiTest() {
        RestAssured.get("/search?term=Better&country=RU").then().assertThat()
                .body("results[0].country", is("RUS"));
    }

    @Test
    public void ParameterCountry4_ItunesApiTest() {
        RestAssured.get("/search?term=Better&country=US").then().assertThat()
                .body("results[0].country", is("USA"));
    }

    @Test
    public void ParameterCountry5_ItunesApiTest() {
        RestAssured.get("/search?term=Better").then().assertThat()
                .body("results[0].country", is("USA"));
    }

}
