Feature: To test countries service

  Scenario: Verify list of countries
    Given I have countries sevice url: https://restcountries.eu/rest/v1/all
    When I get list of all the countries
    Then I get list of all the countries