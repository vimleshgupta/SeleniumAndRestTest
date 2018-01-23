Feature: To test countries service

  Scenario: Verify list of countries
    Given I have countries sevice url: https://restcountries.eu/rest/v1/all
    When I get list of all the countries
    Then I verify following country details
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