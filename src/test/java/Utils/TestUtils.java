package Utils;

import io.restassured.response.Response;
import org.testng.Assert;



public class TestUtils {

    //Verify the http response status returned. Check Status Code is 200?
    public void checkStatusIs200 (Response res) {
        Assert.assertEquals(res.getStatusCode(), 200, "Error in api");

    }

}
