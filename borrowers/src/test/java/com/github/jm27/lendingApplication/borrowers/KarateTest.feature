Feature:Testing API endpoints

  Scenario: Retrieving borrowers
    Given url 'http://localhost:8080/borrowers'
    When method GET
    Then status 200

  Scenario: Retrieving borrowers-loan-requests
    Given url 'http://localhost:8080/borrowers/borrowers-requests'
    When method GET
    Then status 200

  Scenario: Create a new borrower
    Given url 'http://localhost:8080/borrowers'
    And request {"first_name":"John","last_name":"Bravo","funds":0,"credit_score":600,"rating":3 }
    When method POST
    Then status 201

  Scenario: Create a new loan request
    Given url 'http://localhost:8080/borrowers/borrowers-requests'
    And request {"borrower_id":"92f0489a-c9b2-4e9f-a5cd-3946dc3c99a7","loan_amount":5000,"loan_length":24,"interest":3.5,"loan_reason":"buying a used car for work"}
    When method POST
    Then status 201

  Scenario: Retrieve a borrower by id
    Given url 'http://localhost:8080/borrowers/92f0489a-c9b2-4e9f-a5cd-3946dc3c99a7'
    When method GET
    Then status 200

  Scenario: Remove a borrower
    Given url 'http://localhost:8080/borrowers/e69b9c6d-ef3c-4cfb-9d21-d57edfc8a155'
    When method DELETE
    Then status 200

  Scenario: update borrower's information
    Given url 'http://localhost:8080/borrowers/92f0489a-c9b2-4e9f-a5cd-3946dc3c99a7'
    And request {"id":"92f0489a-c9b2-4e9f-a5cd-3946dc3c99a7","first_name":"Pablo","last_name":"Bravo","funds":5000,"credit_score":600,"rating":3 }
    When method PUT
    Then status 200

  Scenario: Retrieve all the transactions for a particular borrower
    Given url 'http://localhost:8080/borrowers/92f0489a-c9b2-4e9f-a5cd-3946dc3c99a7'
    When method GET
    Then status 200
