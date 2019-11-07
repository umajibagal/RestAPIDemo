package get.responsepojo.greetperson;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GreetPersonResonse {

	@SerializedName("response")
	@Expose
	private List<String> response = null;

	public List<String> getResponse() {
		return response;
	}

	public void setResponse(List<String> response) {
		this.response = response;
	}

}
