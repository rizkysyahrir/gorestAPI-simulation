Feature: Request Posts to Gorest API

  @Tugas @positive @andreas
  Scenario: GET Single Posts
    Given Get single posts with valid id 475
    When Send request get single posts
    Then Status code should be 200
    And Validate json schema single user

  @Tugas @negative @andreas
  Scenario: GET Single post with invalid id
    Given Get single posts with invalid id 77777
    When Send request get single posts
    Then Status code should be 404
    And Response body should contain message "Resource not found"
    And Get single posts invalid id assert json validation
