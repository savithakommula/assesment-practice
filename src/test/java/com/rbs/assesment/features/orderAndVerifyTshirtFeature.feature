#Author: savitha.kommula09@gmail.com

@tag
Feature:  Order Tshirt feature
  I want to use this template for my feature file

  @ordertshirt
  Scenario Outline: Order Tshirt and Verify in Order History
    Given I am on Automation Practice website
    When I Signed in to Automation Practice website
    Then It should display Automation Practice my account page
    And I clicked on "<arg1>" tab 
    Then I ordered Tshirt
    And I verified in Orders History
    Examples:
    |arg1|
    |T-SHIRTS|
    
    
  