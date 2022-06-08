package sd.test.definition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sd.test.util.RecursosServicios;
import net.thucydides.core.annotations.Steps;
import sd.test.step.ConversionStep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.ibm.icu.impl.Assert;

public class ConversionDefinition {
	@Steps
	ConversionStep conversionStep;
	String endpoint="";
	
	@Given("^Que accedo al servicio conversión de cadenas$")
	public void que_accedo_al_servicio_conversión_de_cadenas() {
	endpoint = RecursosServicios.endpoint;
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^Ingreso la cadena a convertir \"([^\"]*)\"$")
	public void ingreso_la_cadena_a_convertir(String cadena) {
		conversionStep.crearRequest(cadena);
		
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^Se muestra código satisfactorio$")
	public void se_muestra_código_satisfactorio() {
		conversionStep.ejecutarServicio();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^Se muestra a cadena covertida correctamente$")
	public void se_muestra_a_cadena_covertida_correctamente() {
		String valorMostrado=conversionStep.valorConvertido();
		assertNotNull(valorMostrado);
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

}
