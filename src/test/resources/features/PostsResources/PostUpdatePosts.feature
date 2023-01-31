Feature: Request Posts to Gorest API

  Scenario: Post Create Posts
  @Tugas @positive @andreas
  Scenario: POST Create a new posts with valid bearer token
    Given authorization bearer token
    When post create posts with valid json file
    When Send request post create posts
    Then Status code should be 201 created
    And Validate json schema create posts

  @Tugas @negative @andreas
  Scenario: POST Create a new posts without title
    Given authorization bearer token
    When Post create new posts without title
    When Send request post create posts
    Then Status code should be 422 unprocessable
    And Validate invalid json schema create posts

