Feature: Request Posts to Gorest API

  Scenario: Put Update Posts
  @Tugas @positive @andreas
  Scenario:  PUT Update posts with valid json file
    Given Put update user with id 375 and with valid json file
    When Send request put update user
    When authorization bearer token
    Then Status code should be 200
    And Response body title should be "updateee" and body "updateeee" and id 375 and user_id 720
    And Validate json schema update user

  @Tugas @negative @andreas
    Scenario: PUT Update
    Given PUT Update posts with id "375" and with invalid json file
    When Send request put update user
    Then Status code should be 404
    And Response body message should be "Resource not found"