Feature: Testing List Users Gorest API
  @Tugas @PositiveCase
  Scenario: Get list users with valid parameter page
    Given Get list user with page 200
    When Send request get list user
    Then Should return status code 200
    And Response body id should be 57882
    And Validate json schema list user


  @Tugas @NegativeCase
  Scenario: Get list users with unknown without parameter
    Given Get list users with unknown
    When Send request unknown get list user
    Then Should return status code 404
