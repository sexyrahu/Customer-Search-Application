//import groovy.json.JsonParser;
import java.util.logging.Logger;

import com.google.gson.JsonObject;
import com.jayway.jsonpath.JsonPath;
import io.restassured.http.Method;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;


public class BasicApiTest extends BaseTest{
    public JsonObject jsonObject = null;
    static Logger log = Logger.getLogger(BasicApiTest.class.getName());
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    com.google.gson.JsonParser jsonParser = new com.google.gson.JsonParser();
    Response res;
    String reGex = "[^a-zA-Z0-9_-]";
    public String token;
    private String phone ="8037602400";

    JSONObject requestParams = new JSONObject();

    @Test
    public void T01_GenerateToken() {
        RestAssured.baseURI="http://13.126.80.194:8080";
        RequestSpecification request = RestAssured.given();
        //Verify the http response status returned. Check Status Code is 200?
        request.header("Accept", "application/json");
        request.header("Content-Type","application/json");

        requestParams.put("username","rupeek");
        requestParams.put("password","password");
        request.body(requestParams.toJSONString());
        res= request.post("/authenticate");
        String abc = res.getBody().prettyPrint();
        token = JsonPath.read(abc, "$.token").toString().replaceAll(reGex, " ").trim();
        Assert.assertEquals(200,res.getStatusCode());


    }

    @Test
    public void getUserData() {
        RestAssured.baseURI="http://13.126.80.194:8080";
        RequestSpecification httprequest = RestAssured.given();
        //Verify the http response status returned. Check Status Code is 200?
        httprequest.header("Accept", "application/json");
        httprequest.header("Content-Type","application/json");
        token=token.replaceAll(" ",".");
        String bearer = "Bearer "+token;
        httprequest.header("Authorization",bearer);
        Response response = httprequest.request(Method.GET, "/api/v1/users");
        System.out.println(response.getStatusCode());
        System.out.println(response.body().asString());
        Assert.assertEquals(200,response.getStatusCode());
    }

    @Test
    public void getUserDataWithPhone() {
        RestAssured.baseURI="http://13.126.80.194:8080";
        RequestSpecification httprequest = RestAssured.given();
        //Verify the http response status returned. Check Status Code is 200?
        httprequest.header("Accept", "application/json");
        httprequest.header("Content-Type","application/json");
        String bearer = "Bearer "+token;
        httprequest.header("Authorization",bearer);
        Response response = httprequest.request(Method.GET, "/api/v1/users/phone");
        System.out.println(response.getStatusCode());
        Assert.assertEquals(200,response.getStatusCode());

    }

}

