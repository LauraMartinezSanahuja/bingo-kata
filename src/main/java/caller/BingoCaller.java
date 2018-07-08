package main.java.caller;

import java.util.ArrayList;
import java.util.Random;

public class BingoCaller {

	ArrayList<Integer> calledValues;

	public BingoCaller(int minValue, int maxValue) {
		calledValues = new ArrayList<Integer>();
		for (int i = minValue; i <= maxValue; i++) {
			calledValues.add(i);
		}
	}

	public int callNumber() {
		Random rand = new Random();
		int index = rand.nextInt(calledValues.size());
		int value = calledValues.get(index);
		calledValues.remove(index);
		return value;
	}
}
