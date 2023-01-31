Feature: Testing Create todo Gorest API

  @Tugas
  Scenario: Post create new todo with valid json gorest API
    Given Post create todo with valid json
    When Send request post create todo
    And Set Authentication
    When Send create request new comments and set authentication
    Then Should return status code 201
    And And Response body title should be "ini title baru dibuat", due_on "2023-01-20T00:00:00.000+05:30" and status "completed"
    And Validate json schema create todo

  @Tugas @NegativeCase
  Scenario: Post create new todo with invalid json gorest API
    Given Post create todo with invalid user_id json
    When Send request post create todo
    And Set Authentication
    When Send create request new comments and set authentication
    Then Should return status code 422

  @Tugas @NegativeCase
  Scenario: Post create new todo with invalid json gorest API
    Given Post create todo with invalid title json
    When Send request post create todo
    And Set Authentication
    When Send create request new comments and set authentication
    Then Should return status code 422

  @Tugas @NegativeCase
  Scenario: Post create new todo with invalid json gorest API
    Given Post create todo with invalid due_on json
    When Send request post create todo
    And Set Authentication
    When Send create request new comments and set authentication
    Then Should return status code 422

  @Tugas @NegativeCase
  Scenario: Post create new todo with invalid json gorest API
    Given Post create todo with invalid status json
    When Send request post create todo
    And Set Authentication
    When Send create request new comments and set authentication
    Then Should return status code 422





