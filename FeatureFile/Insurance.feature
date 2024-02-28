Feature: PolicyBazaar

  Scenario Outline: Travel Insurance
    Given user has to launch the policybazzar website
    Then user verify the webPage
    When user clicks Travel Insurance
    Then user verify the travel insurance page
    And user Enters any European country "<Country>", selects from dropdown and clicks next button
    And select start date and end date of trip and clicks next button "<smonthyear>" "<sdate>" "<emonthyear>" "<edate>"
    And user selects number of travellers, their age and ckicks next button "<traveller1age>" "<traveller2age>"
    And user enters pre-existing medical condition of traveller
    And user enters "<mobile number>" and clicks view plan button
    And user selects plan type as student plan
    And user fills the student travel information and trip duration and clicks on apply button
    And user filters the plan from Low to High
    And user need to print three lowest student plans in console and excel

    Examples: 
      | Country | mobile number | smonthyear | sdate | emonthyear | edate | traveller1age | traveller2age |
      | Italy   |    9898999654 | June 2024  |    10 | July 2024  |    10 | 22 years      | 21 years      |

  Scenario Outline: Car Insurance
    Given user navigates back to the home page for car insurance
    When user clicks on Car Insurance
    Then user verify the car insurance page
    And user clicks on view price button without entering car number
    Then user captures the error message
    When user enters the car number "<Car number>" and click on view price
    And user selects car Brand
    And user selects car model
    And user selects car fuel type
    And user selects car variant
    And user selects car registration year
    And user clicks on view price without entering any details
    Then capture the error messages
    When user enters full name "<Name>" , invalid email "<email>" and valid mobile number "<mobile no.>"
    Then capture the error message of invalid email

    Examples: 
      | Car number | Name | email      | mobile no. |
      | TN-23-6543 | John | john@gmail | 9898999654 |

  Scenario: Health Insurance
    Given user navigates back to the home page for health Insurance
    When user clicks on insurance products
    Then user verify the Health insurance
    When user need to print all health insurance menu in console and excel
