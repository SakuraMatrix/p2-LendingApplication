Feature:Testing API endpoints

  Scenario: Retrieving borrowers
    Given url 'http://localhost:8080/borrowers'
    When method GET
    Then status 200

  Scenario: Retrieving borrowers-loan-requests
    Given url 'http://localhost:8080/borrowers/borrowers-requests'
    When method GET
    Then status 200