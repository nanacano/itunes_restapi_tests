package ApiTests.helpers;

import com.jayway.restassured.RestAssured;

public class InitializationTestHelper {

    public static void initialize(int portNum, String base, String host){
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = portNum;
        }
        else{
            RestAssured.port = Integer.valueOf(port);
        }
        String basePath = System.getProperty("server.base");
        if(basePath==null){
            basePath = base;
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("https://itunes.apple.com");
        if(baseHost==null){
            baseHost = host;
        }
        RestAssured.baseURI = baseHost;
    }
}
