Feature: As a VP of Gaming
  I want my game to generate random Bingo cards
  So that people can play

  Scenario Outline: Bingo card generation
    Given I have a Bingo card generator
    When I generate a Bingo card
    Then the generated card has 25 unique spaces
    And column <column> only contains numbers between <lowerBound> and <upperBound> inclusive
    And the generated card has 1 FREE space in the middle

    Examples: 
      | column | lowerBound | upperBound |
      | B      |          1 |         15 |
      | I      |         16 |         30 |
      | N      |         31 |         45 |
      | G      |         46 |         60 |
      | O      |         61 |         75 |
