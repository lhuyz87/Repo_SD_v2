package sd.test.util;
import com.gargoylesoftware.htmlunit.javascript.host.fetch.Request;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utilitarios {
	
	public Response conexion(String jsonRequest, RequestSpecification restAssuredRequest, String metodo, String endPoint) {
	restAssuredRequest.body(jsonRequest);
	Response restAssuredResponse=null;
	switch (metodo) {
	
	case "POST":
		restAssuredResponse = restAssuredRequest.when().post(endPoint);
		break;
	case "GET":
		restAssuredResponse = restAssuredRequest.when().get(endPoint);
		break;
	default:
		break;
	} 
	System.out.println(restAssuredResponse.getBody().asString());
	return restAssuredResponse;
}
}
