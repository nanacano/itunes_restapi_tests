package ApiTests;

import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static ApiTests.helpers.InitializationTestHelper.initialize;
import static com.jayway.restassured.RestAssured.given;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class General_ItunesApiTest {

    @BeforeClass
    public static void setup() {
        initialize(8080, "/search?term=jack+johnson", "https://itunes.apple.com");
    }

    @Test
    public void General1_ItunesApiTest() {
        given().when().get("/").then().statusCode(200);

    }

}
