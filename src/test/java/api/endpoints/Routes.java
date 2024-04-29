package api.endpoints;
/*
 swagger url-https://petstore.swagger.io
 
 post url-https://petstore.swagger.io/v2/user
 get url-https://petstore.swagger.io/v2/user/{username}
 put url-https://petstore.swagger.io/v2/user/{username}
 delete url-https://petstore.swagger.io/v2/user/{username}
 */

 /*
   swagger url-https://petstore.swagger.io
   
   
   post url-https://petstore.swagger.io/v2/pet
   get_url-https://petstore.swagger.io/v2/pet/{petid}
   put-url-https://petstore.swagger.io/v2/pet/{petid}
   delete_url-https://petstore.swagger.io/v2/pet/{petid}
 */
public class Routes {
	
	public static String base_url="https://petstore.swagger.io/v2";
	
	//User module
	
	public static String post_url=base_url+"/user";
	
	public static String get_url=base_url+"/user/{username}";
	
	public static String put_url=base_url+"/user/{username}";
	
	public static String delete_url=base_url+"/user/{username}";
	
	//Store module
	
	public static String petpost_url=base_url+"/pet";
	
	public static String petget_url=base_url+"/pet/{petid}";
	
	public static String petput_url=base_url+"/pet/{petid}";
	
	public static String petdelete_url=base_url+"/pet/{petid}";
	
	//Pet module
	

}
