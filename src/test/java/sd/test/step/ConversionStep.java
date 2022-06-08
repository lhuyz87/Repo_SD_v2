package sd.test.step;
import sd.test.request.ConversionRequest;
import sd.test.response.ConversionResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import sd.test.util.Utilitarios;
import sd.test.util.RecursosServicios;
import net.thucydides.core.annotations.Step;

public class ConversionStep {
	ConversionRequest conversionRequest= new ConversionRequest();
	Utilitarios utilitarios= new Utilitarios();
	private String jsonRequest="";
	private ConversionResponse conversionResponse;
	private RequestSpecification restAssuredRequest;
	private Response response;
	
	@Step("Generar request")
	public void crearRequest(String cadena) {
		jsonRequest =	conversionRequest.crearrequest(cadena);
		System.out.println(jsonRequest);
	}
	@Step("Ejecutar servicio")
	public ConversionResponse ejecutarServicio() {
		restAssuredRequest = SerenityRest.given().contentType("application/json").accept("application/json");
		response = utilitarios.conexion(jsonRequest, restAssuredRequest, "POST", RecursosServicios.endpoint);
		conversionResponse = response.then().extract().body().as(ConversionResponse.class);
		return conversionResponse;
	}
	
	public String valorConvertido () {
		String valor=conversionResponse.getEncodedData();
		return valor;
	}
}

//curl -X POST "http://192.168.0.60:9600/wsrest-segurisign-lite/encodeString" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"data\": \"A\"}"