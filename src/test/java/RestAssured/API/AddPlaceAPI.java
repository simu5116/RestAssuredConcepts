package RestAssured.API;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Assert;
public class AddPlaceAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		String response=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(PayloadJson.addPlaceAPI())
		.when().post("/maps/api/place/add/json").
		then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		JsonPath js=new JsonPath(response);
		//always give path from json
		//suppose we have one json in which , latitude is one node in that we have subnode longitude
		//so it will be js.getString("latitude.longitude")
		String place_id=js.getString("place_id");
		
		String response2=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(PayloadJson.updatePlaceAPI(place_id,"70 Summer walk, USA"))
		.when().put("/maps/api/place/update/json").
		then().log().all().assertThat().body("msg",equalTo("Address successfully updated")).extract().response().asString();
		System.out.println(response2);
		
		//Now with get place api we will see if the address is updaed successfully or not
		//in get method we don't provide any body any header,everything should be part of url only
		
		String response3=given().log().all().queryParam("key","qaclick123").queryParam("place_id",place_id)
		.when().get("/maps/api/place/get/json").
		then().log().all().extract().response().asString();
		
		JsonPath js2=new JsonPath(response3);
		String address=js2.getString("address");
		System.out.println(address);
		Assert.assertEquals(address, "70 Summer walk, USA");
		
	}

}
