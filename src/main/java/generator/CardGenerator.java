package main.java.generator;

public abstract class CardGenerator {

	int rows;
	int columns;

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public abstract String[][] generateCard();

	public void printCard(String[][] card) {
		for (int i = 0; i < rows; i++) {
			String row = "| ";
			for (int j = 0; j < columns; j++) {
				if (card[i][j].length() == 1) {
					row += " ";
				}
				if (card[i][j].length() == 0) {
					row += "  ";
				}
				row += card[i][j] + " | ";
			}
			System.out.println(row);
		}
		System.out.println("");
	}
}
