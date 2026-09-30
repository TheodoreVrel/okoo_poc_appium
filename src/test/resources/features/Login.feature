Feature: Login

  @AUTO-0001 @AUTO-0002 @Android @test
  Scenario: Start the app and validate preliminary stuff
    Given I open the Okoo app
    When I confirm I am an adult
    And I enter the correct result to the multiplication
    And I agree to the questions
    Then I should be on the age selection page

  @AUTO-0002 @Android @test
  Scenario: Choose the age
    Given I am on the age selection page
    When I select the age of 7 years old
    Then I should be on the main page for 7 year olds

#  @AUTO-0002+ @Android @iOS
#  Scenario Outline: Choose the age
#    Given I am on the age selection page
#    When I select the age of <age> years old
#    Then I should be on the main page for <age> year olds
#    Examples:
#      | age |
#      | 11  |
#      | 9   |
#      | 7   |
#      | 5   |
#      | 4   | ------- Ctrl + alt + L


Scenario Outline: Lancement depuis divers types de page
  Given je suis sur la page <page>
  When je clique sur <clic>
  Then je suis emmené sur la vidéo dans le player
  Examples:
    | page      | clic             |
    | home      | vignette         |
    | programme | vignette         |
    | programme | bouton continuer |