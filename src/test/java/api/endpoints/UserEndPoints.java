package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	
	//Created for perform CRUD operations..CRUD=create,retrieve,update,delete
	
	public static Response create_User(User payload)
	{
		Response res=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(Routes.post_url);
		
		return res;
	}
	
	public static Response read_User(String userName)
	{
		Response res=given()
		.pathParam("username", userName)
		
		.when()
		.get(Routes.get_url);
		
		return res;
	}
	
	public static Response update_User(String userName,User payload)
	{
		Response res=given()
				
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload)
		
		.when()
		.put(Routes.put_url);
		
		return res;
	}

	public static Response delete_User(String userName)
	{
		Response res=given()
		.pathParam("username", userName)
		
		.when()
		.delete(Routes.delete_url);
		
		return res;
	}
}
