
Feature:  In order to use demoqa site
          As an user
          I want to create an new account

  Background:
    Given I am new to the website I want to create an account
    When I go to the registration form

  @runOnly
    Scenario: Should be able to succesfully register on website
    And I complete all the required registration details correctly :  First Name with "Armando"
    And I fill Last Name with"Perez"
    And I select the hobby "dance"
    And I fill the phoneNumber with"1234567890"
    And I fill the username with "username34561"
    And I fill the e-mail with "test12344test@test.com"
    And I fill the password with "password123"
    And I fill the password confirmation with "password123"
    And I submit the form
    Then I will be registered on the website


  Scenario: Should not be able to register on the website without completing all
            mandatory fields.
    And I select the hobby "dance"
    And I fill the phoneNumber with"1234567890"
    And I fill the username with "username1a1123123as"
    And I fill the e-mail with "test121a1asd1@test.com"
    And I submit the form
    Then I will be asked to fill all the mandatory fields correctly


  Scenario: Should not be able to register on the website with an user that already Exist
    And I complete all the required registration details correctly :  First Name with "Armando"
    And I fill Last Name with"Perez"
    And I select the hobby "dance"
    And I fill the phoneNumber with"username34561"
    And I fill the username with "uasernaxmeaa11123123asd12"
    And I fill the e-mail with "test1211aw1df3@test.com"
    And I fill the password with "password123"
    And I fill the password confirmation with "password123"
    And I submit the form
    Then It should be shown a message saying that the User already exist

  Scenario: Should not be able to register on the website with an E-mail that already Exist
    And I complete all the required registration details correctly :  First Name with "Armando"
    And I fill Last Name with"Perez"
    And I select the hobby "dance"
    And I fill the phoneNumber with"1234567890"
    And I fill the username with "usserzernamseaa11221123123"
    And I fill the e-mail with "test12344test@test.com"
    And I fill the password with "password123"
    And I fill the password confirmation with "password123"
    And I submit the form
    Then It should be shown a message saying that the E-mail already exist


