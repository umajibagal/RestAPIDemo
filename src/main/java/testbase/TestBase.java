package testbase;

import org.testng.annotations.BeforeTest;

import com.google.gson.Gson;

import service.Service;

public class TestBase {
	protected Service service;
	protected Gson gson;
	

	@BeforeTest
	public void beforeTest() {
		service = new Service();
		gson = new Gson();
	}
}
