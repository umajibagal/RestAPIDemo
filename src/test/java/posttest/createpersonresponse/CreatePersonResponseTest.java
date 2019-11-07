package posttest.createpersonresponse;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import post.responsepojo.createPerson.CreatePersonResponse;
import testbase.TestBase;

public class CreatePersonResponseTest extends TestBase {
	private String name;
	private String surname;
	private String landMark;
	private String city;
	private String state;
	private String zipCode;

	@BeforeClass
	public void beforeClass() {
		name = "name";
		surname = "surname";
		landMark = "landMark";
		city = "city";
		state = "state";
		zipCode = "zipCode";
	}

	@Test
	public void getCreatePersonResponse() {

		Response response = service.createPerson(name, surname, landMark, city, state, zipCode);

		String createPersonData = response.prettyPeek().asString();

		CreatePersonResponse createPersonResponse = gson.fromJson(createPersonData, CreatePersonResponse.class);

		String actualName = createPersonResponse.getResponse().get(0).getName();
		String actualState = createPersonResponse.getResponse().get(0).getAddress().getState();

		AssertJUnit.assertEquals(response.getStatusCode(), 200);

		AssertJUnit.assertEquals(actualName, "name");

		AssertJUnit.assertEquals(actualState, "state");

		System.out.println("Data  : " + createPersonData);

	}

}
