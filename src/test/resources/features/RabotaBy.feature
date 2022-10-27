Feature: Mood panda test

  Scenario: Navigation in application
    Given open home page
    When i click on menu item "What?"
    Then i check that uri "monitor-your-mood"
    When i click on menu item "How?"
    Then i check that uri "how-to-use-a-mood-diary"
    When i click on menu item "About"
    Then i check that uri "about"


  Scenario:
      Given open home page
      When i click on menu item "Login"
      Then i check that uri "login"
      When i enter email "test@test.ru", password "123456"
      And i click login button
      Then i check error message "Your email or password is wrong"