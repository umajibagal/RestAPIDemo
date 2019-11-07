package service;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.google.gson.Gson;

import get.responsepojo.greetperson.GreetPersonResonse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import post.requestpojo.createPerson.AddressRequest;
import post.requestpojo.createPerson.PersonRequest;
import post.responsepojo.createPerson.CreatePersonResponse;
import post.responsepojo.createPerson.PersonResponse;

public class Service {

	List<JSONObject> personList;

	public Response getPersonGreetin(String personName) {
		
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.accept("application/json");
		
		Response response= requestSpecification.get(ServiceURL.greetingPersonURL+"/"+personName);
		return response;
	}
	public Response createPerson(String name, String surname, String landmark, String city, String state,
			String zipcode) {
		PersonRequest createPerson = new PersonRequest();

		createPerson.setName(name);
		createPerson.setSurname(surname);

		AddressRequest address = new AddressRequest();

		createPerson.setAddress(address);
		address.setLandmark(landmark);
		address.setCity(city);
		address.setState(state);
		address.setZipcode(zipcode);

		RequestSpecification requestSpecification = RestAssured.given();

		requestSpecification.contentType("application/json");
		requestSpecification.accept("application/json");

		JSONObject jsonObject = new JSONObject(createPerson);
		personList = new ArrayList<JSONObject>();
		personList.add(jsonObject);

		requestSpecification.body(personList.toString());

		Response response = requestSpecification.post(ServiceURL.createPersonURL);

		return response;
	}

	public static void main(String[] args) {
		Service service = new Service();
		Response response = service.getPersonGreetin("sharu");
		System.out.println("Status code  : "+response.getStatusCode());
		String data = response.asString();
		System.out.println("Data : "+data);
		
		Gson gson = new Gson();
		GreetPersonResonse greePersonResonse = gson.fromJson(data, GreetPersonResonse.class);
	
		String name = greePersonResonse.getResponse().get(0);
		System.out.println("name : "+name);
	}
	public static void main123(String[] args) {
		Service service = new Service();
		Response response = service.createPerson("umaji2", "bagal2", "katraj", "pune", "Maha", "411046");
		System.out.println(response.getStatusCode());
		String data = response.asString();
		System.out.println("Response data  : " + data);

		Gson gson = new Gson();
		CreatePersonResponse createPersonResponse = gson.fromJson(data, CreatePersonResponse.class);

		if (response.getStatusCode() == 200) {
			String city = createPersonResponse.getResponse().get(0).getAddress().getCity();
			String name = createPersonResponse.getResponse().get(0).getName();
			String surname = createPersonResponse.getResponse().get(0).getSurname();

			System.out.println("Name : " + name);
			System.out.println("Surname : " + surname);
			System.out.println("City : " + city);

			assertEquals(name, "umaji2");
			assertEquals(surname, "bagal2");
			assertEquals(city, "pune");
		}

	}
}
