package motoresDeBusqueda.google.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import motoresDeBusqueda.google.steps.UsuarioGoogle;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class UsuarioDefinicionesDePasos {

    @Steps(shared = true)
    UsuarioGoogle usuario;

    @Given("^Que (.*) entra en Google$")
    public void ingresar_a_google(String nombreDeUsuario) {
        usuario.isCalled(nombreDeUsuario);
        usuario.ingresaAGoogle();
    }

    @When("^(.*) realiza una busqueda de: (.*)$")
    public void busca_por_palabra_clave(String nombreDeUsuario, String palabraClave) {
        usuario.isCalled(nombreDeUsuario);
        usuario.buscaPorPalabraClave(palabraClave);
    }

    @Then("^(.*) deberia poder ver resultados que contengan la palabra: (.*)$")
    public void deberia_ver_resutlados_con_palabra(String nombreDeUsuario, String palabraEsperada) {
        usuario.isCalled(nombreDeUsuario);
        usuario.deberiaVerResutladosConPalabra(palabraEsperada);
    }

    @Then("^(.*) deberia ver un texto: (.*) más escuchados: (.*)$")
    public void deberia_ver_resultado_de_titulo_con_texto_correcto(String nombreDeUsuario ,String tituloDeResultado, String textoDeResultadoEsperado) {
        usuario.isCalled(nombreDeUsuario);
        usuario.deberiaVerResultadoDeTituloConTextoCorrecto(tituloDeResultado,textoDeResultadoEsperado);
    }
}

