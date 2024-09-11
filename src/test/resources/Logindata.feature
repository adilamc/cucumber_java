Feature: Login Functionality

  In order to do internet banking
  As a valid ParaBank customer
  I want to login successfully

  Scenario: Login Successful

    Given I'm in login page of ParaBank Application
    When I enter valid credentials
      | autotester | password |
    Then I should be taken to Overview page

