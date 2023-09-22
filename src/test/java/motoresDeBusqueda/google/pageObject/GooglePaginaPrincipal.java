package motoresDeBusqueda.google.pageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

//@DefaultUrl("https://www.google.com.co/")
public class GooglePaginaPrincipal extends PageObject {

    @FindBy(xpath = "//textarea[@id='APjFqb']")
    WebElementFacade cajaDeBusqueda;

    //@FindBy(xpath ="//input[@class='gNO89b' and @value='Buscar con Google']")
    @FindBy(xpath ="//input[@class='gNO89b' and @value='Buscar con Google']")
    WebElementFacade botonDeBusqueda;

    public void ingresarPalabraClave(String palabraClave) {
        cajaDeBusqueda.type(palabraClave);


    }

    public void realizarBusqueda() {

        botonDeBusqueda.click();
    }
}
