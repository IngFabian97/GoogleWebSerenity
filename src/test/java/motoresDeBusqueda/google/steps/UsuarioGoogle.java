package motoresDeBusqueda.google.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import motoresDeBusqueda.google.pageObject.GooglePaginaPrincipal;
import motoresDeBusqueda.google.pageObject.GooglePaginaResultado;
import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class UsuarioGoogle extends ScenarioActor {
    String actor;

    @Steps (shared = true)
    GooglePaginaPrincipal paginaPrincipal;

    @Steps (shared = true)
    GooglePaginaResultado paginaResultado;

    @Step("#actor ingresa a la pagina principal de Google")
    public void ingresaAGoogle()
    {
        paginaPrincipal.setDefaultBaseUrl("https://www.google.com.co");
        paginaPrincipal.open();
    }

    @Step("#actor realiza una busqueda de: {0}")
    public void buscaPorPalabraClave(String palabraClave) {
        paginaPrincipal.ingresarPalabraClave(palabraClave);
        paginaPrincipal.realizarBusqueda();

    }


    @Step("#actor deberia poder ver resultados que contengan la palabra: {0}")
    public void deberiaVerResutladosConPalabra(String palabraEsperada) {
        List<String> resultados = paginaResultado.obtenerResultados();
        resultados.replaceAll(String::toLowerCase);
        for (int i = 0; i < resultados.size(); i++) {
            System.out.println(resultados.get(i));
        }

        assertThat(resultados, Matchers.everyItem(Matchers.containsString(palabraEsperada)));
    }

    @Step("#actor deberia ver un texto: {0} más escuchados: {1}")
    public void deberiaVerResultadoDeTituloConTextoCorrecto(String tituloDeResultado, String textoDeResultadoEsperado) {
        String texto = paginaResultado.obtenerTextoDeTituloResultado(tituloDeResultado);
        System.out.println(texto);
        System.out.println(textoDeResultadoEsperado);
        assertThat(texto,containsString(textoDeResultadoEsperado));
    }
}

