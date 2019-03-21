
Feature: Controller Test

 
  
  Background:
  
  	Given a user run the application
  
   
  Scenario: load completed order        
    Then all completed order need to be printed 
    
    Scenario: load pending order    
    Then all pending order need to be printed
   
    Scenario: load waiting order    
    Then all waiting order need to be printed
    