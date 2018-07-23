package ApiTests;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static ApiTests.helpers.InitializationTestHelper.initialize;
import static com.jayway.restassured.RestAssured.given;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParameterVersion_ItunesApiTest {

    @BeforeClass
    public static void setup() {
        initialize(8080, "/search?term=jack+johnson", "https://itunes.apple.com");
    }

    @Test
    public void ParameterVersion1_ItunesApiTest() {
        given().when().get("/search?term=Better&version=1").then().statusCode(200);
    }

    @Test
    public void ParameterVersion2_ItunesApiTest() {
        given().when().get("/search?term=Better&version=0").then().statusCode(404);
    }
}
