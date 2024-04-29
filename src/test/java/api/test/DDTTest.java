package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTTest {
	
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void test_postUser(String userID,String userName,String fname,String lname,String useremail,String pwd,String ph)
	{
		User userpayload=new User();
		userpayload.setId(Integer.parseInt(userID));
		userpayload.setUsername(userName);
		userpayload.setFirstName(fname);
		userpayload.setLastName(lname);
		userpayload.setEmail(useremail);
		userpayload.setPassword(pwd);
		userpayload.setPhone(ph);
		
		Response res=UserEndPoints.create_User(userpayload);
		Assert.assertEquals(res.getStatusCode(),200);
	}
	
	@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void test_getUserByName(String userName)
	{
		Response res=UserEndPoints.read_User(userName);
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority=3,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void test_deleteUserByName(String userName)
	{
		Response res=UserEndPoints.delete_User(userName);
		Assert.assertEquals(res.getStatusCode(), 200);
	}

}
