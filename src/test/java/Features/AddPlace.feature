Feature: API Testing of Loaction

  @AddPlace
  Scenario Outline: Validate Testing of ADD_Place
    Given Add Add_Place payload with "<name>" "<language>" "<address>"
    When Call "AddPlaceAPI" with "Post" http request
    Then verify API sucess with statusCode 200
    Then check "status" message as "OK"
    Then check "scope" message as "APP"
    And verify place_id map with "<name>" using "GetPlaceAPI" request

    Examples: 
      | name        | language | address         |
      | rahulshetty | English  | Bangalore,India |

  #|BigBoss    | Hindi    | Mumbai         |
  
  @DeletePlace
  Scenario: Validate Delete payload
    Given Add delete payload with place_id
    When Call "DeletePlaceAPI" with "Post" http request
    Then verify API sucess with statusCode 200
    And check "status" message as "OK"
