package Tests;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest {
	
	@Test
	public void getRequestTest()
	{
		Response response = RestAssured
				.given()
				.when()
				.get("https://jsonplaceholder.typicode.com/users/1")
				.then()
				.extract()
				.response();
		
		System.out.println("status code: "+ response.getStatusCode());
		System.out.println("Response body: "+ response.getBody().asString());
		Assert.assertEquals(response.getStatusCode(),200, "Status code should be 200!");
		
	}

}
