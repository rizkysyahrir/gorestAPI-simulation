Feature: Delete Todo feature

  @Tugas
  Scenario Outline: Delete todos with valid id
    Given Delete todo with valid id <id>
    When Send request delete todo
    Then Should return status code 404
    Examples:
      | id   |
      | 1607 |

  @Tugas @NegativeCase
  Scenario: Delete todos with invalid id
    Given Delete todo with invalid id "zzzzz"
    When Send request delete todo
    Then Should return status code 404



