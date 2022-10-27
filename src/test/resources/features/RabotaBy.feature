Feature: Rabota by test
  
  Scenario: Search jobs
    Given open main page
    When i wait subscribe city
    When i change city "Минск"
    When i send on search field name job "QA Automation"
    And i click on search button
    And i check on title have name "QA Automation" of jobs
    Then i equal count of work "53" on result and count of work "53" from feature file
