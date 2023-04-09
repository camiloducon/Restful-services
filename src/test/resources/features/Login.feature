Feature: login

  Background: Login

    * def jsonData = read('../jsonFiles/DatosLogin.json')

  Scenario: Servicio metodo POST

    Given url "https://restful-booker.herokuapp.com/auth"
    And header Accept = 'application/json'
    And request jsonData
    When method post
    Then status 200
    And print response