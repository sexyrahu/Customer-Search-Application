
package utils;
import com.google.gson.*;
import com.jayway.jsonpath.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;


public class ApiUtils {

    //Global Setup Variables
    public static String path;
    public static String jsonPathTerm;
    public static String HOST = "http://13.126.80.194:8080";
    String reGex ="[^a-zA-Z0-9_-]";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    // JsonParser jsonParser = new JsonParser();

    //Sets Base URI
    public static void setBaseURI (){
        RestAssured.baseURI = HOST;
    }
    //Sets base path
    public static void setBasePath(String basePathTerm){
        RestAssured.basePath = basePathTerm;
    }

    //Set Port
    public static void setPort(){
        RestAssured.port=Integer.valueOf(8080);
    }
    //Reset Base URI (after test)
    public static void resetBaseURI (){
        RestAssured.baseURI = null;
    }

    //Reset base path
    public static void resetBasePath(){
        RestAssured.basePath = null;
    }

    //Sets ContentType
    public static void setContentType (ContentType Type){
        given().contentType(Type);
    }


    //Returns response by given path
    public static Response getResponsebyPath(String path) {
        return get(path);
    }

    //Returns response
    public static Response getResponse() {
        return get();
    }


//    //Returns JsonPath object
//    public static JsonPath getJsonPath (Response res) {
//        String json = res.asString();
//        System.out.print("returned json: " + json +"\n");
//        String apiKey= JsonPath.read(res, "$..apiKey").toString().replaceAll(reGex, "").trim();
//
//        return new JsonPath(json,);
//    }

//    public void returnResponseAsJson(){
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        JsonParser jsonParser = new JsonParser();
//        JsonElement je = jsonParser.parse(res.getBody().asString());
//        String prettyJsonString = gson.toJson(je);
//        log.info(prettyJsonString);
//
//    }


//    //Returns JsonPath object
//    public static JsonPath getJsonPath (Response res) {
//        String json = res.asString();
//        //System.out.print("returned json: " + json +"\n");
//        return new JsonPath(json);
//    }

}
