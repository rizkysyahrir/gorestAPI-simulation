Feature: Testing List Todos Gorest API

  @Tugas
  Scenario: Get list todos gorest API
    Given Get list todo
    When Send request get list todo
    Then Should return status code 200
    And Validate json schema list todo





