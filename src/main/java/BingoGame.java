package main.java;

import java.util.ArrayList;

import main.java.caller.*;
import main.java.generator.*;
import main.java.player.Player;

public class BingoGame {

	BingoCaller bingoCaller;
	CardGenerator cardGenerator;
	Player player;

	public BingoGame(String type) {
		if (type.equals("US")) {
			bingoCaller = new USBingoCaller();
			cardGenerator = new USCardGenerator();

			String[][] card = cardGenerator.generateCard();
			// cardGenerator.printCard(card);

			player = new Player(card);
		} else {
			System.out.println("Type " + type + " not currently supported.");
		}
	}

	public void playUserWins() {
		this.play();
		while (!player.callCorrectBingo()) {
			this.play();
		}
	}

	public void playUserLooses() {
		this.play();
		while (!player.callWrongBingo()) {
			this.play();
		}
	}

	public void play() {
		int number = bingoCaller.callNumber();
		player.calledNumber(number);
	}

	public ArrayList<Integer> getPlayerCard() {
		return player.getPlayerRemainNumbers();
	}
}
