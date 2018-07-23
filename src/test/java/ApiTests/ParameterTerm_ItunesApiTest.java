package ApiTests;

import com.jayway.restassured.RestAssured;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static ApiTests.helpers.InitializationTestHelper.initialize;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.path.json.JsonPath.from;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParameterTerm_ItunesApiTest {

    @BeforeClass
    public static void setup() {
        initialize(8080, "/search?term=jack+johnson", "https://itunes.apple.com");
    }

    @Test
    public void ParameterTerm1_ItunesApiTest() {
        given().when().get("/search?term=Better").then().statusCode(200);
    }

    @Test
    public void ParameterTerm2_ItunesApiTest() {
        String response = get("/search?term=Better").asString();
        String trackName = from(response).getString("results[0].trackName").toLowerCase();
        String collectionName = from(response).getString("results[0].trackName").toLowerCase();
        Assert.assertTrue(trackName.contains("better") || collectionName.contains("better"));
    }
}
