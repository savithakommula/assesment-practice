#Author: savitha.kommula09@gmail.com

@tag
Feature: Personal Information
  I want to use this template for my feature file

  @tag2
  Scenario: update personal information
    #Given I am on Automation Practice website
     #And I click on Signin button
    #When I enter my credentials
    #Then It should display Automation Practice home page
    When I click on account button
    And I click on my personal information
    Then I update my first name
    
  