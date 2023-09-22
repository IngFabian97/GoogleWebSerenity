
@Cucumber
Feature: Busqueda en Google

  este feature se trata de hacer una busqueda en Google y revisar los resultados obtenidos de esa busqueda

  @Regresion
  Scenario:  Buscar resultados relevantes
    Given Que Fabian entra en Google
      When Fabian realiza una busqueda de: rock nacional
      Then Fabian deberia poder ver resultados que contengan la palabra: rock

  Scenario Outline:  Verificar que los resultados con texto relevante al titulo
    Given Que Fabian entra en Google
    When Fabian realiza una busqueda de: rock nacional
    Then Fabian deberia ver un texto: <texto> más escuchados: <titulo>

    Examples:
      | Descripcion            | titulo                                               | texto                  |
      | Resultado en argentina | Artistas más escuchados de rock argentino            | Explora los artistas   |
      | resultado argentino    | ROCK NACIONAL ARGENTINO - playlist by Top Global     | ¡Las mejores canciones |
      | resultado wikipedia    | Rock de Argentina - Wikipedia, la enciclopedia libre | El rock argentino      |