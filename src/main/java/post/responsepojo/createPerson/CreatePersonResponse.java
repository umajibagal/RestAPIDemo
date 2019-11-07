package post.responsepojo.createPerson;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreatePersonResponse {

	@SerializedName("response")
	@Expose
	private List<PersonResponse> response = null;

	public List<PersonResponse> getResponse() {
		return response;
	}

	public void setResponse(List<PersonResponse> response) {
		this.response = response;
	}

}
