package main.java.player;

import java.util.ArrayList;
import java.util.Random;

public class Player {

	ArrayList<Integer> numbers;

	public Player(String[][] card) {
		numbers = new ArrayList<Integer>();
		for (String[] rows : card) {
			for (String value : rows) {
				if (value.matches("\\d+")) {
					numbers.add(Integer.parseInt(value));
				}
			}
		}
	}

	public boolean calledNumber(int calledNumber) {
		if (numbers.contains(calledNumber)) {
			numbers.remove((Object) calledNumber);
			return true;
		}
		return false;
	}

	public boolean callWrongBingo() {
		if (numbers.size() < 2) {
			return true;
		}
		Random rand = new Random(2);
		return !numbers.isEmpty() && rand.nextInt() == 1;
	}

	public boolean callCorrectBingo() {
		return numbers.isEmpty();
	}

	public ArrayList<Integer> getPlayerRemainNumbers() {
		// System.out.println(numbers.toString());
		return numbers;
	}
}
