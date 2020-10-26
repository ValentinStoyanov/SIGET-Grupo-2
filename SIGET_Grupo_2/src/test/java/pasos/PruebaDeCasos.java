package pasos;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.model.Reunion;
import com.persistence.*;

public class PruebaDeCasos {
	
  @Autowired

  private ReunionRepository reunionRepository;
	
	
  @Given("^Estamos conectados a la BBDD$")
	  public void given() throws Throwable {
		  
		  Reunion p1 = new Reunion(
		  "2",
		  "Segunda tarea de prueba",
		  false
		  );
		  this.reunionRepository.insert(p1);
  }

  @When("^Cuando le doy a visualizar mis reuniones$")
  	public void when() throws Throwable {
	  
  }

  @Then("^Devuelve las reuniones$")
	  public void then() throws Throwable {
		  List<Reunion>lista = this.reunionRepository.findAll();
  }

  @And("^tenemos 2 reuniones en la base de datosn$")
  	public void and() throws Throwable {
  }
}
