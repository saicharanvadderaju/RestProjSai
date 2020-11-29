package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	
	public static RequestSpecification req;
	
	
	public RequestSpecification requestspecif() throws Exception
	{
		if(req==null)
		{
		PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));
		
		req=new RequestSpecBuilder().setBaseUri(getGlobalValues("baseURL"))
				.addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		
		return req;
		}
		return req;
	}
	
	public String getGlobalValues(String key) throws Exception
	{
		Properties prop=new Properties();
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Saicharan\\workspaceNEWPROJECT\\APIBDDFramework\\src\\test\\java\\Resources\\global.properties");
	    
		prop.load(fis);
		
		return prop.getProperty(key);
		
	
	}
	
	public String getJsonPath(Response response, String key)
	{
		String rsp=response.asString();
		
		 JsonPath jp=new JsonPath(rsp);
		 
		 return jp.get(key).toString();
	}

}
