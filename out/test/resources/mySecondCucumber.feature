Feature: Login

  Scenario Outline: Login Facebook

    Given i have access to facebook
    When i type the email: <email>
    And i type the password: <password>
    And i click on login button
    Then i should be logged

    Examples:
      | email        | password |
      | upb1@upb.com | 123      |
      | upb2@upb.com | 345      |
      | upb3@upb.com | 4567     |
      | upb4@upb.com | 678      |