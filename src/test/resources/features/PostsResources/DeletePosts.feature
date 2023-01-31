Feature: Delete Posts Feature
  @Tugas @positive @andreas
  Scenario Outline: Delete posts with valid id
    Given delete posts with valid id <id>
    When Send request delete posts
    Then response code should be 200 OK
    Examples:
      | id  |
      | 374 |
      | 373   |

  @Tugas @negative @andreas
  Scenario Outline: Delete posts with invalid id
    Given delete posts with invalid id "<id>"
    When Send request delete posts
    Then response code should be 404 not found
    Examples:
      | id |
      | aa |
      | @# |

  @Tugas @positive @andreas
  Scenario: DELETE posts
    Given authorization bearer token
    And Delete comments with id 372
    When Send request delete posts
    Then Status code should be 200 OK

