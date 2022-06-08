Feature: Happy Path
    @TestCaseKey=QA-T3968
    Scenario Outline: Happy Path
        
        Given Que accedo al servicio conversión de cadenas
        When Ingreso la cadena a convertir "<cadena>"
        Then Se muestra código satisfactorio
        And Se muestra a cadena covertida correctamente
        Examples: 
        |cadena|
        |prueba|
        |valor|