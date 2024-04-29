package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	User userpayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setUp()
	{
		faker=new Faker();
		userpayload=new User();
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5,10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		logger=LogManager.getLogger(this.getClass());
		
	}
	
	@Test(priority=1)
	public void test_postUser()
	{
		logger.info("****Creating user******");
		Response res=UserEndPoints.create_User(userpayload);
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		logger.info("**** user is created ******");
	}
	
	@Test(priority=2)
	void test_getUserByName()
	{
		logger.info("****reading  user info ******");
		
        Response res=UserEndPoints.read_User(this.userpayload.getUsername());
        res.then().log().all();
        
        Assert.assertEquals(res.getStatusCode(), 200);
        
        logger.info("**** user info is displayed ******");
        
	}
	@Test(priority=3)
	void test_updateUserByName()
	{
		logger.info("**** Updating user ******");
		
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		
		Response res=UserEndPoints.update_User(this.userpayload.getUsername(),userpayload);
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//Checking data after update
		
		Response resafterupdate=UserEndPoints.read_User(this.userpayload.getUsername());
		Assert.assertEquals(resafterupdate.getStatusCode(), 200);
		
		logger.info("**** user is updated ******");
		
	}
	
	@Test(priority=4)
	void test_deleteUserByName()
	{
		logger.info("**** deleting user ******");
		
		Response res=UserEndPoints.delete_User(this.userpayload.getUsername());
		Assert.assertEquals(res.getStatusCode(), 200);
		
		logger.info("**** user  is deleted ******");
		
	}

}
