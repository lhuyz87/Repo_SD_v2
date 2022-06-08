package sd.test.request;
import org.json.JSONObject;

public class ConversionRequest {
	
	public String crearrequest(String cadena) {
		JSONObject myObject = new JSONObject();
		myObject.put("data", cadena);
		return myObject.toString();
	}

}

//{
//	  "data": "A"
//	}
