Feature: Login

  Background:
    Given i have access to facebook

  Scenario: Login Facebook

    When i type the email: upb@upb.com
    And i type the password: 123456
    And i click on login button
    Then i should be logged

  Scenario: Login Facebook2

    When i type the email: upb@upb.com
    And i click on login button


  Scenario: Login Facebook3

    And i click on login button
    Then i should be logged