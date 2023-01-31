Feature: Testing Get Single List Todos Gorest API

  @Tugas
  Scenario Outline: Get single list todos gorest API
    Given Get single list todo with valid id <id>
    When Send request get single list todo id
    Then Should return status code 200
    Examples:
      | id   |
      | 1607 |

  @Tugas
  Scenario Outline: Get single list todos gorest API
    Given Get single list todo with valid user_id <user_id>
    When Send request get single list todo user_id
    Then Should return status code 200
    Examples:
      | user_id |
      | 3268    |

  @Tugas @NegativeCase
  Scenario Outline: Get single list todos gorest API
    Given Get single list todo with invalid id "zzzzz"
    When Send request get single list todo id
    Then Should return status code 404


