Feature: Login Functionality

  In order to do internet banking
  As a valid ParaBank customer
  I want to login successfully

  Scenario Outline: Login Successful

    Given I'm in login page of ParaBank Application
    When I enter valid <username> and <password> with <userFullName>
    Then I should be taken to Overview page

    Examples:
    |username|password|userFullName|
    |"autotester"|"password"|"AutoTester"|
    |"tautester" |"password"|"TAU Tester"|

