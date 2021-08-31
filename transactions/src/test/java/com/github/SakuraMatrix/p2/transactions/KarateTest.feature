Feature:Testing API endpoints

  Scenario: Retrieving transactions
    Given url 'http://localhost:8080/transactions'
    When method GET
    Then status 200

  Scenario: Retrieving a single transaction by transaction id
    Given url 'http://localhost:8080/transactions/6f23c30c-0dcc-4b43-8bb1-d8172adc6077'
    When method GET
    Then status 200
    And match $ contains {id: 6f23c30c-0dcc-4b43-8bb1-d8172adc6077}

  Scenario: Retrieving a single transaction by lender id
    Given url 'http://localhost:8080/transactions/lender/5b6962dd-3f90-4c23-8f61-eabfa4a803e2'
    When method GET
    Then status 200

  Scenario: Retrieving a single transaction by borrower id
    Given url 'http://localhost:8080/transactions/borrower/5b6962dd-3f90-4c63-8f61-eabfa4a803e2'
    When method GET
    Then status 200

  Scenario: Remove a transaction
    Given url 'http://localhost:8080/transactions/0f23b09a-b321-4306-96ba-4ef3fff59c6f'
    When method DELETE
    Then status 200

  Scenario: Creating a new transaction
    Given url 'http://localhost:8080/transactions'
    And request  { "lenderId": "5b6962dd-3f90-4c23-8f61-eabfa4a803e2", "borrowerId": "5b6962dd-3f90-4c63-8f61-eabfa4a803e2","repaymentTerm": 24,"amount": 7778.0,"interestRate": 5.4}
    When method POST
    Then status 201

  Scenario: Updating transaction status
    Given url 'http://localhost:8080/transactions/6f23c30c-0dcc-4b43-8bb1-d8172adc6077'
    And request {"id": "6f23c30c-0dcc-4b43-8bb1-d8172adc6077","lenderId": "5b6962dd-3f90-4c23-8f61-eabfa4a803e2","borrowerId": "5b6962dd-3f90-4c63-8f61-eabfa4a803e2","startDate": "2021-08-27","repaymentTerm": 24,"amount": 5670.0,"interestRate": 5.4,"monthlyPayment": 0.0,"status": "FULFILLED"}
    When method PUT
    Then status 200
