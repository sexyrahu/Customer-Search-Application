import Utils.TestUtils;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;


public class BaseTest {

    //Instantiate a Helper Test Methods (testUtils) Object
    TestUtils testUtils = new TestUtils();
    Utillity utillity = new Utillity();

    //Test Setup

    @BeforeTest
    public void setup (){

        utillity.setBaseURI();
    }

    @AfterTest
    public void afterTest (){
        //Reset Values
        utillity.resetBaseURI();
        utillity.resetBasePath();
    }

}
