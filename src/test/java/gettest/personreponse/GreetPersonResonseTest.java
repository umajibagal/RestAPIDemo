package gettest.personreponse;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import get.responsepojo.greetperson.GreetPersonResonse;
import io.restassured.response.Response;
import testbase.TestBase;

public class GreetPersonResonseTest extends TestBase{

	private String greetName;
	private Response resonseGreeting;
	@BeforeClass
	public void beforeClass() {
		greetName = "Sayaji";
	}
	@Test
	public void getGreetingPersonNameResponse() {
		
		resonseGreeting = service.getPersonGreetin(greetName);
		
		int actualStatusCode = resonseGreeting.getStatusCode();
		int expectedStatusCode = 200;
		
		assertEquals(actualStatusCode, expectedStatusCode);
		
		String greetingData = resonseGreeting.asString();
		
		GreetPersonResonse greet = gson.fromJson(greetingData, GreetPersonResonse.class); 
		
		String actualName = greet.getResponse().get(0);
		
		assertTrue(actualName.contains(actualName));
		
	}
}
