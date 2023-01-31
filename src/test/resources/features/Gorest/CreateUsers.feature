Feature: Testing create new users Go RestAPI

  @Tugas @PositiveCase
  Scenario: Post create new users with valid json
    Given Create new users with valid json
    When Send request post create new user
    Then Should return status code 201
    And Validate json schema create new users

  @Tugas @NegativeCase
  Scenario: Post create same email with valid json
    Given Create users same email with valid json
    When Send request post create new user
    Then Should return status code 422
    And Response body message should be email: "has already been taken"
    And Validate json schema create users same email