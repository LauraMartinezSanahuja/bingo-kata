package test.java.code_bindings;

import java.util.ArrayList;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.BingoGame;

public class CheckPlayerBingoSteps {

	BingoGame game;
	ArrayList<Integer> playerCard;

	@Given("^a player calls Bingo (.*) all numbers on their card have been called$")
	public void playerCallsBingo(String callingBingo) {
		game = new BingoGame("US");
		if (callingBingo.equals("before")) {
			game.playUserLooses();
		} else if (callingBingo.equals("after")) {
			game.playUserWins();
		} else {
			System.out.println("Incorrect option");
		}
	}

	@When("I check the card")
	public void checkCard() {
		playerCard = game.getPlayerCard();
	}

	@Then("the player is the winner")
	public void playerWins() {
		assert (playerCard.isEmpty());
	}

	@Then("the player is not the winner")
	public void playerDoesNotWin() {
		assert (!playerCard.isEmpty());
	}
}