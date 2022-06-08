package sd.test.response;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConversionResponse {
	@SerializedName("encodedData")
	@Expose
	private String encodedData;

	public String getEncodedData() {
		return encodedData;
	}

	public void setEncodedData(String encodedData) {
		this.encodedData = encodedData;
	}
}

//{
//	  "encodedData": "QQ=="
//	}