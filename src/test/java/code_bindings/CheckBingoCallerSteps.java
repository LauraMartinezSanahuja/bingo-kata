package test.java.code_bindings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.caller.BingoCaller;
import main.java.caller.USBingoCaller;

public class CheckBingoCallerSteps {
	BingoCaller bingoCaller;
	ArrayList<Integer> numbers;

	@Given("^I have a Bingo caller$")
	public void bingoCaller() {
		bingoCaller = new USBingoCaller();
	}

	@When("^I call a number$")
	public void callNumber() {
		numbers = new ArrayList<Integer>();
		numbers.add(bingoCaller.callNumber());
	}

	@When("^I call a number (\\d+) times$")
	public void callNumberNtimes(int times) {
		numbers = new ArrayList<Integer>();
		for (int i = 0; i < times; i++) {
			numbers.add(bingoCaller.callNumber());
		}
	}

	@Then("^the number is between (\\d+) and (\\d+) inclusive$")
	public void validateNumber(int minValue, int maxValue) {
		if (numbers.size() == 1) {
			int value = numbers.get(0);
			assert (value >= minValue && value <= maxValue);
		} else {
			System.out.println("More than one value to validate");
		}
	}

	@Then("^all numbers between (\\d+) and (\\d+) are present$")
	public void allNumbersPresent(int minValue, int maxValue) {
		boolean allNumbersPresent = true;
		for (int i = minValue; i < maxValue; i++) {
			if (!numbers.contains(i)) {
				System.out.println("Number " + i + " is not present. - " + numbers.contains(i));
				allNumbersPresent = false;
			}
		}
		assert (allNumbersPresent);
	}

	@Then("^no number has been called more than once$")
	public void noRepeatedNumbers() {
		boolean noRepeatedNumbers = true;
		Set<Integer> uniqueNumbers = new HashSet<Integer>();
		for (int number : numbers) {
			if (!uniqueNumbers.add(number)) {
				System.out.println("Number " + number + " is repeated.");
				noRepeatedNumbers = false;
			}
		}
		assert (noRepeatedNumbers);
	}
}