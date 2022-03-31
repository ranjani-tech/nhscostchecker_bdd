@Regression
@Walesperson @endtoend

Feature: Find help available is available or not to user on NHS (UK national health system) costs
  As a user from Wales (UK)
  I need to know what help I can get with my NHS (UK national health system) costs
  So that I can get the treatment I need


  @startpage
  Scenario: Verify the UI layout of NHS cost checker tool
    Given User is on NHS cost checker tool page
    When User skip cookie selection
    Then I should be able to view Start button as per UX


  @smoketest
  Scenario: Check as a user from Wales what help I could get to pay for NHS costs
    Given User is on NHS cost checker tool page
    When user clicks start button
    And user selects country live in as "Wales"
    And user selects GP practice location in scotland or Wales as "Yes"
    And user select country of dental practice as "Wales"
    And user enters date of birth as 21-06-1989
    And user select civil partnership status as "Yes"
    And user select tax claim status as "No"
    And user select Maternity details as "No"
    And user select war pensioner and injury details status as "No"
    And user select diabetes status as "No"
    And user select glaucoma status as "No"
    And user select care home details as "No"
    And user select financial details as "No"
    Then user should get a result that "You get help with NHS costs"


  @age16under
  Scenario: Age under 16 as a user from Wales what help I could get to pay for NHS costs
    Given User is on NHS cost checker tool page
    When user clicks start button
    And user selects country live in as "Wales"
    And user selects GP practice location in scotland or Wales as "Yes"
    And user select country of dental practice as "Wales"
    And user enters date of birth as 21-06-2020
    Then user should get based on the age result that "Because you're under 16:"
    And NHS Cost Checker responds show NHS Cost Available
      | NHS prescriptions |
      | NHS dental check-ups and treatment |
      | sight tests                        |
      | NHS wigs and fabric supports |
      | £4.25 each week of your pregnancy from the 10th week |
      | £8.50 each week for children from birth to 1 year old |
      | £4.25 each week for children between 1 and 4 years old |
      | travel for NHS treatment                               |


  @age20above
  Scenario: Age 20 as a user from Wales what help I could get to pay for NHS costs
    Given User is on NHS cost checker tool page
    When user clicks start button
    And user selects country live in as "Wales"
    And user selects GP practice location in scotland or Wales as "Yes"
    And user select country of dental practice as "Wales"
    And user enters date of birth as 21-06-2002
    And user select civil partnership status as "Yes"
    And user select tax claim status as "No"
    And user select Maternity details as "No"
    And user select war pensioner and injury details status as "No"
    And user select diabetes status as "No"
    And user select glaucoma status as "No"
    And user select care home details as "No"
    And user select financial details as "No"
    Then user should get a result that "You get help with NHS costs"
    And NHS Cost Checker responds show NHS Cost Available
      | NHS prescriptions\nIf your prescription is dispensed in Wales or you have an Entitlement Card |
      | NHS dental check-ups\nIf you are under 25 and are registered with a dental practice in Wales |
      | £4.25 each week of your pregnancy from the 10th week                   |
      | £8.50 each week for children from birth to 1 year old                  |
      | £4.25 each week for children between 1 and 4 years old                 |


  @age30above
  Scenario: Age 30 as a user from Wales what help I could get to pay for NHS costs
    Given User is on NHS cost checker tool page
    When user clicks start button
    And user selects country live in as "Wales"
    And user selects GP practice location in scotland or Wales as "Yes"
    And user select country of dental practice as "Wales"
    And user enters date of birth as 21-06-1992
    And user select civil partnership status as "Yes"
    And user select tax claim status as "No"
    And user select Maternity details as "No"
    And user select war pensioner and injury details status as "No"
    And user select diabetes status as "No"
    And user select glaucoma status as "No"
    And user select care home details as "No"
    And user select financial details as "No"
    Then user should get a result that "You get help with NHS costs"
    And NHS Cost Checker responds show NHS Cost Available
      | NHS prescriptions\nIf your prescription is dispensed in Wales or you have an Entitlement Card |
      | £4.25 each week of your pregnancy from the 10th week                        |
      | £8.50 each week for children from birth to 1 year old                       |
      | £4.25 each week for children between 1 and 4 years old                      |


  @age40above
  Scenario: Age 40 as a user from Wales what help I could get to pay for NHS costs
    Given User is on NHS cost checker tool page
    When user clicks start button
    And user selects country live in as "Wales"
    And user selects GP practice location in scotland or Wales as "Yes"
    And user select country of dental practice as "Wales"
    And user enters date of birth as 21-06-1982
    And user select civil partnership status as "Yes"
    And user select tax claim status as "No"
    And user select Maternity details as "No"
    And user select war pensioner and injury details status as "No"
    And user select diabetes status as "No"
    And user select glaucoma status as "No"
    And user select care home details as "No"
    And user select financial details as "No"
    Then user should get a result that "You get help with NHS costs"
    And NHS Cost Checker responds show NHS Cost Available
      | NHS prescriptions\nIf your prescription is dispensed in Wales or you have an Entitlement Card |
      | £4.25 each week of your pregnancy from the 10th week                        |
      | £8.50 each week for children from birth to 1 year old                       |
      | £4.25 each week for children between 1 and 4 years old                      |


  @age50above
  Scenario: 50 as a user from Wales what help I could get to pay for NHS costs
    Given User is on NHS cost checker tool page
    When user clicks start button
    And user selects country live in as "Wales"
    And user selects GP practice location in scotland or Wales as "Yes"
    And user select country of dental practice as "Wales"
    And user enters date of birth as 21-06-1963
    And user select civil partnership status as "Yes"
    And user select tax claim status as "No"
    And user select Maternity details as "No"
    And user select war pensioner and injury details status as "No"
    And user select diabetes status as "No"
    And user select for all family members glaucoma status as "No"
    And user select care home details as "No"
    And user select financial details as "No"
    Then user should get a result that "You get help with NHS costs"
    And NHS Cost Checker responds show NHS Cost Available
      | NHS prescriptions\nIf your prescription is dispensed in Wales or you have an Entitlement Card |
      | £4.25 each week of your pregnancy from the 10th week                        |
      | £8.50 each week for children from birth to 1 year old                       |
      | £4.25 each week for children between 1 and 4 years old                      |


  @age61andabove
  Scenario: Age 60 as a user from Wales what help I could get to pay for NHS costs
    Given User is on NHS cost checker tool page
    When user clicks start button
    And user selects country live in as "Wales"
    And user selects GP practice location in scotland or Wales as "Yes"
    And user select country of dental practice as "Wales"
    And user enters date of birth as 21-06-1961
    And user select civil partnership status as "Yes"
    And user select tax claim status as "No"
    And user select Maternity details as "No"
    And user select war pensioner and injury details status as "No"
    And user select care home details as "No"
    And user select financial details as "No"
    Then user should get a result that "You get help with NHS costs"
    And NHS Cost Checker responds show NHS Cost Available
      | NHS prescriptions |
      | sight tests       |
      | NHS dental check-ups\nIf you are registered with a dental practice in Wales |
      | £4.25 each week of your pregnancy from the 10th week                        |
      | £8.50 each week for children from birth to 1 year old                       |
      | £4.25 each week for children between 1 and 4 years old                      |


  @age62andabove
  Scenario: Age 80 as a user from Wales what help I could get to pay for NHS costs
    Given User is on NHS cost checker tool page
    When user clicks start button
    And user selects country live in as "Wales"
    And user selects GP practice location in scotland or Wales as "Yes"
    And user select country of dental practice as "Wales"
    And user enters date of birth as 21-06-1960
    And user select civil partnership status as "Yes"
    And user select tax claim status as "No"
    And user select war pensioner and injury details status as "No"
    And user select care home details as "No"
    And user select financial details as "No"
    Then user should get a result that "You get help with NHS costs"
    And NHS Cost Checker responds show NHS Cost Available
      | NHS prescriptions |
      | sight tests       |
      | NHS dental check-ups\nIf you are registered with a dental practice in Wales |
      | £4.25 each week of your pregnancy from the 10th week                        |
      | £8.50 each week for children from birth to 1 year old                       |
      | £4.25 each week for children between 1 and 4 years old                      |


