Feature: As a VP of Gaming
	I want my game to call out Bingo numbers
	So that people can play with their cards

  Scenario: Called numbers are correct
    Given I have a Bingo caller
		When I call a number
		Then the number is between 1 and 75 inclusive

  Scenario: Called numbers are not repeated
    Given I have a Bingo caller
		When I call a number 75 times
		Then all numbers between 1 and 75 are present
		And no number has been called more than once
