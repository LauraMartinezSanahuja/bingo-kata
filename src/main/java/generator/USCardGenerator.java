package main.java.generator;

import java.util.ArrayList;
import java.util.Random;

public class USCardGenerator extends CardGenerator {

	int rows = 6;
	int columns = 5;
	String[][] card = new String[rows][columns];

	public USCardGenerator() {
		super.rows = this.rows;
		super.columns = this.columns;

		card[0][0] = "B";
		card[0][1] = "I";
		card[0][2] = "N";
		card[0][3] = "G";
		card[0][4] = "O";
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (i == 3 && j == 2) {
					card[i][j] = "";
				} else {
					card[i][j] = "0";
				}
			}
		}
	}

	@Override
	public String[][] generateCard() {
		for (int j = 0; j < columns; j++) {
			ArrayList<Integer> columnNumbers = new ArrayList<Integer>();
			for (int i = 1; i < rows; i++) {
				if (card[i][j].equals("0")) {
					int number = getNumber(j);
					if (columnNumbers.isEmpty() || !columnNumbers.contains(number)) {
						card[i][j] = "" + number;
						columnNumbers.add(number);
					} else {
						i--;
					}
				}
			}
		}
		// printCard();
		return card;
	}

	public int getNumber(int range) {
		Random rand = new Random();
		int value = rand.nextInt(15) + 1 + range * 15;
		return value;
	}
}
