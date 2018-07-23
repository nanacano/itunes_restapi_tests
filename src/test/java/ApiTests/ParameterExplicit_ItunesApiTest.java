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
public class ParameterExplicit_ItunesApiTest {

    @BeforeClass
    public static void setup() {
        initialize(8080, "/search?term=jack+johnson", "https://itunes.apple.com");
    }

    @Test
    public void ParameterExplicit1_ItunesApiTest() {
        given().when().get("/search?term=Better&explicit=yes").then().statusCode(200);
    }

    @Test
    public void ParameterExplicit2_ItunesApiTest() {
        given().when().get("/search?term=Better&explicit=no").then().statusCode(200);
    }


}
