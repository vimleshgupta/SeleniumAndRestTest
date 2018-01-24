Feature: To test countries service

  Scenario: Verify total number of countries
    Given I have countries service url to get all countries
    When I request to get details
    Then I get status code as 200
    And I get total 250 countries

  Scenario: Verify a country's details
    Given I have countries service url to get india country details
    When I request to get details
    Then I get status code as 200
    And I verify following country's details
      | name           | India                                            |
      | topLevelDomain | [.in]                                            |
      | alpha2Code     | IN                                               |
      | alpha3Code     | IND                                              |
      | callingCodes   | [91]                                             |
      | capital        | New Delhi                                        |
      | altSpellings   | [IN, Bhārat, Republic of India, Bharat Ganrajya] |
      | region         | Asia                                             |
      | subregion      | Southern Asia                                    |
      | population     | 1275840000                                       |
      | latlng         | [20.0, 77.0]                                     |
      | demonym        | Indian                                           |
      | area           | 3287590.0                                        |
      | gini           | 33.4                                             |
      | timezones      | [UTC+05:30]                                      |
      | borders        | [AFG, BGD, BTN, MMR, CHN, NPL, PAK, LKA]         |
      | nativeName     | भारत                                             |
      | numericCode    | 356                                              |
      | currencies     | [INR]                                            |
      | languages      | [hi, en]                                         |
      | translations   | {de=Indien, es=India, fr=Inde, ja=インド, it=India} |
      | relevance      | 3                                                |

  Scenario: Verify when user sends a request to get a country which does not exist
    Given I have countries service url to get aassddff country details
    When I request to get details
    Then I get status code as 404
