package api.test;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PetEndPoints;
import api.endpoints.UserEndPoints;
import api.payload.Pet;
import api.payload.User;
import io.restassured.response.Response;

public class PetTest {
	

	Faker faker;
	Pet userpayload;
	
	@BeforeClass
	public void setUp()
	{
		faker=new Faker();
		userpayload=new Pet();
		
		HashMap<String, String> categoryMap = new HashMap<String, String>();
        categoryMap.put("id", "1");
        categoryMap.put("name", "Dogs");
        
        
        ArrayList<String> photoUrlList = new ArrayList<String>();
        photoUrlList.add("dummyPhotoURL");

        HashMap<String, String> tag = new HashMap<String, String>();
        tag.put("id", "0");
        tag.put("name", "dummyTagNAme");

        ArrayList<HashMap<String, String>> tags = new ArrayList<HashMap<String, String>>();
        tags.add(tag);

        
        userpayload.setId(faker.number().digit());
        userpayload.setName("Updated" + faker.name().firstName());
        userpayload.setCategory(categoryMap);
        userpayload.setPhotoUrls(photoUrlList);
        userpayload.setTags(tags);
        userpayload.setStatus("available");
		
	}
	
	@Test(priority=1)
	public void test_postPet()
	{
		
		Response res=PetEndPoints.create_Pet(userpayload);
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		
	}
	
	@Test(priority=2)
	void test_getPetById()
	{
		 
		
        Response res=PetEndPoints.read_Pet(this.userpayload.getId());
        res.then().log().all();
        
        Assert.assertEquals(res.getStatusCode(), 200);
        
         
        
	}
	
	@Test(priority=3)
	void test_updatePetById()
	{
		 
		
		HashMap<String, String> categoryMap = new HashMap<String, String>();
        categoryMap.put("id", "2");
        categoryMap.put("name", "Doggie");
        
         
        userpayload.setCategory(categoryMap);
        userpayload.setName("Updated" + faker.name().firstName());
        
  
        
		 Response res=PetEndPoints.update_Pet(this.userpayload.getId(), userpayload);
	       res.then().log().all();
	       
	        
	        Assert.assertEquals(res.getStatusCode(), 200);
	        
	        //after uodate
	        
	        Response resafterupdate=PetEndPoints.read_Pet(this.userpayload.getId());
	        res.then().log().all();
	        
	       Assert.assertEquals(resafterupdate.getStatusCode(), 200);
		
	}
	
	@Test(priority=4)
	void test_deletePetByID()
	{
		Response res=PetEndPoints.delete_Pet(this.userpayload.getId());
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}

}
