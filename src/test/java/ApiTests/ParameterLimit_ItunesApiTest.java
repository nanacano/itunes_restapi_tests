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
public class ParameterLimit_ItunesApiTest {

    @BeforeClass
    public static void setup() {
        initialize(8080, "/search?term=jack+johnson", "https://itunes.apple.com");
    }

    @Test
    public void ParameterLimit1_ItunesApiTest() {
        given().when().get("/search?term=Better&limit=50").then().statusCode(200);
    }

    @Test
    public void ParameterLimit2_ItunesApiTest() {
        RestAssured.get("/search?term=Better").then().assertThat()
                        .body("results.size()", is(50));
    }


    @Test
    public void ParameterLimit3_ItunesApiTest() {
        RestAssured.get("/search?term=Better&limit=13").then().assertThat()
                        .body("results.size()", is(13));
    }
}
