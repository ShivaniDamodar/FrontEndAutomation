Feature: Search for Samsung phones on Amazon

  Scenario: List Samsung phones with specific specifications
    Given user is on the Amazon.co.uk homepage
    When user navigate to All and Electronics and Computers and Phones and Accessories and Mobile Phones 
    And user clicks on Mobile Phones
    And user filter phones by Camera Resolution  
    And user filter phones by Model Year  
    And user set the price range
    Then user should see a list of Samsung phones meeting the criteria