Feature: Play videos
  Background:
    Given initial setup
  @AUTO-0003 @Android
  Scenario: Play the first video of a program's page
    Given I am on a program's page
    When I click on a video
    Then the player opens and the video starts
  @AUTO-0004 @Android
  Scenario: Play a video by clicking on "Regarder un épisode"
    Given I am on a program's page
    When I click "Regarder un épisode"
    Then the player opens and the video starts
  @AUTO-0005 @Android
  Scenario: Play a downloaded video
    Given I am on the downloads tab and there is at least one downloaded video
    When I click on a video
    Then the player opens and the video starts
  @AUTO-0006 @Android
  Scenario: Play a video after interacting with the program
    Given I am on a program with interaction
    When I click on the interaction button
    And I click off
    And I click on a video
    Then the player opens and the video starts
