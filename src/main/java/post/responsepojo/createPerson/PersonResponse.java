package post.responsepojo.createPerson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PersonResponse {

	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("surname")
	@Expose
	private String surname;
	@SerializedName("address")
	@Expose
	private AddressResponse address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public AddressResponse getAddress() {
		return address;
	}

	public void setAddress(AddressResponse address) {
		this.address = address;
	}

}