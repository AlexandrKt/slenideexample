Feature: Search Functionality

  Scenario: Successful search
    Given I am on the Rozetka homepage
    When I enter "laptop" in the search bar
    And I click the search button
    Then I should see search results for "Ноутбуки"

  Scenario: Search with no results
    Given I am on the Rozetka homepage
    When I enter "nonexistentproduct" in the search bar
    And I click the search button
    Then I should see a message saying "«nonexistentproduct»"