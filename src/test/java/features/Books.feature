Feature: Add book to collection and display isbn
  Scenario: Add book to collection
    Given User is on landing page
    When User enters <username> and <password> to login
    Then User clicks on a book name
    Then User adds book to collection
