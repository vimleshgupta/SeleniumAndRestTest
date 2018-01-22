Feature: To test flight booking journey

  Scenario: Create a basket and verify basket, booker's and passenger details
    Given I navigate to home page
    When I enter following details for flight
      | From          | Luton      |
      | To            | Alicante   |
      | DepartureDate | 2018-02-22 |
      | ReturnDate    | 2018-02-24 |
    And I see quantity as 1 in adults passanger section
    And I click on show flights button
    Then I am on basket page
    When I pick first available flight from departure route on 22 Feb
    And I pick first available flight from return route on 24 Feb
    Then I see selected departure flight details in the basket on Thu 22nd Feb
    And I see selected return flight details in the basket on Sat 24th Feb
    And I click on continue button in the basket section
    And I skip the Seat selection page
    And I skip the Seat selection page
    And I skip the Hold luggage & sports equipment page
    And I accept and continue cabin bags only
    And I skip the Travel insurance page
    And I skip the Hotels page
    And I skip the Car hire page
    Then I am on checkout page
    And I select new user and enter my email addrresss: jonsnow@gmail.com
    And I click on continue button for sign up in the checkout page
    Then I see Booker's contact details section
    And I enter following Booker's contact details
      | Title            | Mr               |
      | Firstname        | Jon              |
      | Sirname          | Snow             |
      | Password         | jonsnow          |
      | Address          | 339, high street |
      | Town/City        | slough           |
      | Postcode         | SL11TX           |
      | Telephone number | 07777777777      |
    And I click on continue button for Booker's contact details in the checkout page
    Then I see Booker's contact details section is done
    And I following information in the Booker's contact details section
      | Name    | Mr Jon Snow                    |
      | Email   | jonsnow@gmail.com              |
      | Country | United Kingdom                 |
      | Mobile  | +44 7777777777                 |
      | Address | 339, high street, slough, SL11TX |
    Then I see Passenger details section
    And I select Leisure as reason for travel
    And I enter following passenger details
      | Title | Firstname | Lastname | Age |
      | Mr    | Jon       | Snow    | 18+ |
    When I click on continue button for Passenger details in the checkout page
    Then I see Passenger details section is done
    And I see passenger details in the Passenger details section: Jon Snow, aged 18+
    Then I see selected departure flight details in the basket on Thu 22nd Feb
    And I see selected return flight details in the basket on Sat 24th Feb

  Scenario: Verify error scenarios
    Given I navigate to home page
    When I click on show flights button
    Then I see destination error
    When I enter following details for flight
      | From          | Luton      |
      | To            | Alicante   |
    And I click on show flights button
    Then I see departure date error
    When I enter following details for flight
      | DepartureDate | 2018-02-22 |
    And I click on show flights button
    Then I see return date error
    When I choose one way
    And I click on show flights button
    Then I am on basket page
