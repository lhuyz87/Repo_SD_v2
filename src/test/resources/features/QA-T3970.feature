Feature: Cadena vacía
    @TestCaseKey=QA-T3970
    Scenario: Cadena vacía
        
        Given Que accedo al servicio conversión de cadenas
        When Dejo la cadena vacía a convertir
        Then Se muestra código de error
        And Se muestra el mensaje de error