Feature: Request Posts to Gorest API

  @Tugas @positive @andreas
  Scenario: GET Users Posts
    Given Get users post with valid id 394
    When Send request get user posts
    Then Status code should be 200 OK

    #bug
  @Tugas @negative @andreas
    Scenario: GET Users post with invalid id
      Given Get users post with invalid id "%^&%^"
      When Send request get user posts
      Then Status code should be 400