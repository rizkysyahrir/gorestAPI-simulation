Feature: Testing delete user Gorest API
  As a user i want delete user

  @Tugas @PositiveCase
  Scenario Outline: Delete users with valid id
    Given Delete user with valid id <id>
    When Send request delete user
    Then Should return status code 204
    Examples:
      | id  |
      | 403 |
      | 402 |

  @Tugas @NegativeCase
  Scenario Outline: Delete users with id unregister
    Given Delete user with valid id <id>
    When Send request delete user
    Then Should return status code 404
    Examples:
      | id  |
      | 403 |
      | 402 |