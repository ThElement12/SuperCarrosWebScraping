Feature: Supercarros Web Scraping

  Scenario: Search for the average cost of a specific car
    Given Open the SuperCarros URL
    Then Search car by brand "Toyota" and model "Corolla"
    And Click search button
    Then Scrap the data from the results
    And Present the scraped data