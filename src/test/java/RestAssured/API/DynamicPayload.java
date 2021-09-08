package RestAssured.API;

import static io.restassured.RestAssured.given;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicPayload {
	
	@Test(dataProvider="getData")
	public void addBook(String aisle,String number)
	{
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().log().all().header("Content-Type","application/json")
		.body(PayloadJson.addBookjson(aisle,number))
		.when().post("Library/Addbook.php").
		then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		
		JsonPath js=new JsonPath(response);
		String ID=js.get("ID");
		
		System.out.println(ID);
		
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[3][2];
		data[0][0]="book4";
		data[0][1]="1004";
		data[1][0]="book5";
		data[1][1]="1005";
		data[2][0]="book6";
		data[2][1]="1006";
		return data;
	}

}
