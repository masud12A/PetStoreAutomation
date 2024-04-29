package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints {
	
	public static Response create_Pet(Pet payload)
	{
		Response res=given()
		.contentType("application/json")
		.accept("application/json")
		.body(payload)
		
		.when()
		.post(Routes.petpost_url);
		
		return res;
	}
	
	public static Response read_Pet(String petId)
	{
		Response res=given()
		.pathParam("petid", petId)
		
		.when()
		.get(Routes.petget_url);
		
		return res;
	}

	public static Response update_Pet(String petId,Pet payload)
	{
		Response res=given()
				
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("petid", petId)
		.body(payload)
		
		.when()
		.put(Routes.petput_url);
		return res;
	}
	
	public static Response delete_Pet(String petId)
	{
		Response res=given()
		.pathParam("petid", petId)
		
		.when()
		.delete(Routes.petdelete_url);
		return res;
	}

}
