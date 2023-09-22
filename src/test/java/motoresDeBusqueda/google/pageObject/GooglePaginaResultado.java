package motoresDeBusqueda.google.pageObject;

import net.serenitybdd.core.pages.PageObject;

import java.util.List;
import java.util.stream.Collectors;

public class GooglePaginaResultado extends PageObject {

    public static final String TITULO_RESULTADO = "h3[contains(text(),'Rock')]";

    public static final String TITULO_RESULTADO_CON_TEXTO = "//div[contains(@class,'MjjYud')] and contains(.,'{0}'";
    public static final String DESCRIPCION_DE_TEXTO = "...//div[contains(@class,'VwiC3b yXK7lf MUxGbd yDYNvb lyLwlc lEBKkf')]";


    public List<String> obtenerResultados(){
        return findAll(TITULO_RESULTADO)
                .stream()
                .map(element -> element.getAttribute("textContent"))
                .collect(Collectors.toList());
    }

    public String obtenerTextoDeTituloResultado(String tituloDeResultado) {
        return findBy(TITULO_RESULTADO_CON_TEXTO,tituloDeResultado)
                .then().findBy(DESCRIPCION_DE_TEXTO)
                .then().getText();


    }
}
