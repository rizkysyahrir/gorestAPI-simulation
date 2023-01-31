Feature: Testing update users gorest API

  @Tugas @PositveCase
  Scenario: Put update user with valid json
    Given PUT update user with valid json with id 57882
    When Send request PUT update user
    Then Should return status code 200
    And Response body put should be email "febrians@gmail.com", name "Febrian Syahrir", gender "male" and status "active"
    And Validate json schema update users

  @Tugas @NegativeCase
  Scenario: Put update user with valid json without email
    Given PUT update user with valid json with id 57882 without email
    When Send request PUT update user
    Then Should return status code 422
    And Response body message put should be email: can't be blank
    And Validate json schema update users without email

