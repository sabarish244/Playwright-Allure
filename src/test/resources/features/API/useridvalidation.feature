Feature: Get User By ID using API

@RestAPI
  Scenario Outline: Get User by ID
    Given the API base URL is "https://jsonplaceholder.typicode.com"
    When I send a GET request to "/users/<user_id>"
    Then the response status code should be <status_code>
    And the response should contain "<user_name>"

    Examples: 
      | user_id | status_code | user_name     |
      |       1 |         200 | Leanne Graham |
