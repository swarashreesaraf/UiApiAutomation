Feature: Login

  @ui @smoke
  Scenario: User logs in with valid credentials
    Given I open the login page
    When I log in with username "standard_user" and password "secret_sauce"
    Then I should see the products page
