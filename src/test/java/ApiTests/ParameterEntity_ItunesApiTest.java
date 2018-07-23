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
public class ParameterEntity_ItunesApiTest {

    @BeforeClass
    public static void setup() {
        initialize(8080, "/search?term=jack+johnson", "https://itunes.apple.com");
    }

    @Test
    public void ParameterEntity1_ItunesApiTest() {
        given().when().get("/search?term=love&entity=software").then().statusCode(200);
    }

    @Test
    public void ParameterEntity2_ItunesApiTest() {
        RestAssured.get("/search?term=love&entity=software").then().assertThat()
                .body("results[0].kind", is("software"));
    }

    @Test
    public void ParameterEntity3_ItunesApiTest() {
        RestAssured.get("/search?term=jack+johnson&entity=musicVideo").then().assertThat()
                .body("results[0].kind", is("music-video"));
    }
}
