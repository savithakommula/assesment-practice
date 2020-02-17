#Author: savitha.kommula09@gmail.com

@tag
Feature: Upating Personal Information
  I want to use this template for my feature file

  @updatefirstName
  Scenario: Update First name in personal information
     Given I am on Automation Practice website
     When I Signed in to Automation Practice website
     When I click on account button
     And I click on my personal information
     Then I update my first name
     And I verified the changes for first name
     And I close my browser
    
  