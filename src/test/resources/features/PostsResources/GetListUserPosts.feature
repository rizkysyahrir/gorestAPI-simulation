Feature: Request Posts to Gorest API
  bug
  @Tugas @positive @andreas
  Scenario: GET list user without parameter
    Given Get list user without parameter
    When Send request get list posts without parameter
    Then Status code should be 200
    And Validate json schema list user

  @Tugas @positive @andreas
  Scenario Outline: Get list user with valid parameter page
    Given Get list user with valid parameter <page>
    When Send request get list posts
    Then Status code should be 200
    Examples:
      | page |
      | 2    |

#    bug
  @Tugas @negative @andreas
  Scenario Outline: Get list user with invalid parameter
    Given Get list user with invalid parameter "<page>"
    When Send request get list posts
    Then Status code should be 404
    Examples:
      | page    |
      | ^*&^&*^ |

    @Tugas  @negative @andreas
      Scenario: Get list user with unknown parameter
      Given Get list user with unknown parameter
      When Send request get list posts unknown parameter
      Then Status code should be 404
