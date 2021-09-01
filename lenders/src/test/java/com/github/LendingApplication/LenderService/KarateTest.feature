Feature: Testing API endpoints

  Scenario: Retrieving lenders
    Given url 'http://localhost:8080/lenders'
    When method GET
    Then status 200

  Scenario: Retrieving a single lender by lender id
    Given url 'http://localhost:8080/lenders/33f01101-9b14-42f8-ad3f-ace41409d1a8'
    When method GET
    Then status 200

  Scenario: Remove a lender
    Given url 'http://localhost:8080/lenders/33f01101-9b14-42f8-ad3f-ace41409d1a8'
    When method DELETE
    Then status 200

  Scenario: Creating a new lender
    Given url 'http://localhost:8080/lenders'
    And request  {"id": "33f01101-9b14-42f8-ad3f-ace41409d1a8","firstName": "Jonathan", "phoneNumber": "415-341-8403", "lastName":"Shay", "taxId": 3841, "investmentLimit": 4600}
    When method POST
    Then status 201

  Scenario: Updating lender investment limit
    Given url 'http://localhost:8080/lenders/6f23c30c-0dcc-4b43-8bb1-d8172adc6077'
    And request {"id": "33f01101-9b14-42f8-ad3f-ace41409d1a8","firstName": "Jonathan", "phoneNumber": "415-341-8403", "lastName":"Shay", "taxId": 3841, "investmentLimit": 4600}
    When method PUT
    Then status 200