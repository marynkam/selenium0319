@tag
Feature: Flight reservation
  I want to login and reserve some flight

  @tag1
  Scenario: login to the app
    Given I open main page
    When I fill the login form with login "Martyna" and pass "perfecta"
    Then I should see the flight reservation form
    
    Scenario: reserve flight
    Given I open main page
    When I fill the login form with login "Martyna" and pass "perfecta"
    And I choose "2" passangers 
    And I choose one way trip type
    And I start from "London" at month: "3" day "22"
    And I end at "Paris" at month: "3" day "25"
    And I want to fly first class using "Pangea Airlines"
    Then I submit first level of my flight reservation
    
    Scenario: select flight
    Given I open main page
    When I fill the login form with login "Martyna" and pass "perfecta"
    And I choose "1" passanger 
    And I choose one way trip type
    And I start from "London" at month: "3" day "26"
    And I end at "Frankfurt" at month: "3" day "30"
    And I want to fly Economy class using "Pangea Airlines"
    Then I submit first level of my flight reservation
