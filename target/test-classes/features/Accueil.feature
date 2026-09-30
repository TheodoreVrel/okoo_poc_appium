Feature: Accueil
  @FindFallbackImages
  Scenario: Check if there are programs with no images
    Given I open the Okoo app
    When I search the main page
    Then there shouldn't be any programs without images
