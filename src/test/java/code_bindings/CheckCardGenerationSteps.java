package test.java.code_bindings;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.generator.CardGenerator;
import main.java.generator.USCardGenerator;

public class CheckCardGenerationSteps {

	CardGenerator cardGenerator;
	String[][] card;

	@Given("I have a Bingo card generator")
	public void bingoCardGenerator() {
		cardGenerator = new USCardGenerator();
	}

	@When("I generate a Bingo card")
	public void generateBingoCard() {
		card = (String[][]) cardGenerator.generateCard();
	}

	@Then("^the generated card has (\\d+) unique spaces$")
	public void checkCardSpaces(int number) {
		int countSpaces = 0;
		for (int i = 0; i < cardGenerator.getRows(); i++) {
			for (int j = 0; j < cardGenerator.getColumns(); j++) {
				if (card[i][j].matches("\\d+") || card[i][j].matches("")) {
					countSpaces++;
				}
			}
		}
		assert (countSpaces == number);
	}

	@Then("^column (.*) only contains numbers between (.*) and (.*) inclusive")
	public void checkCardNumbers(String columnLetter, int lowerBound, int upperBound) {
		int column = 0;
		for (int j = 0; j < cardGenerator.getColumns(); j++) {
			if (card[0][j].equals(columnLetter)) {
				column = j;
				break;
			}
		}

		for (int i = 1; i < cardGenerator.getRows(); i++) {
			if (column != 2 || (column == 2 && i != 3)) {
				int number = Integer.parseInt(card[i][column]);
				assert (number >= lowerBound && number <= upperBound);
			}
		}
	}

	@Then("the generated card has 1 FREE space in the middle")
	public void checkCardMiddleSpace() {
		assert (card[3][2].equals(""));
	}
}