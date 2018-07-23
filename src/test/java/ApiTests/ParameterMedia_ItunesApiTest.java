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
public class ParameterMedia_ItunesApiTest {

    @BeforeClass
    public static void setup() {
        initialize(8080, "/search?term=jack+johnson", "https://itunes.apple.com");
    }

    @Test
    public void ParameterMedia1_ItunesApiTest() {
        given().when().get("/search?term=Better&media=movie").then().statusCode(200);
    }

    @Test
    public void ParameterMedia2_ItunesApiTest() {
        RestAssured.get("/search?term=Better&media=movie").then().assertThat()
                .body("results[0].kind", is("feature-movie"));
    }

}
