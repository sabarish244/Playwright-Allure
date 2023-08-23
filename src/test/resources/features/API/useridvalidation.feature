Feature: Get User By ID using API

@userid
  Scenario: Get User by ID
    Given the API base URL is "https://jsonplaceholder.typicode.com"
    When I send a GET request to "/users/1"
    Then the response status code should be 200
    And the response should contain "Leanne Graham"
