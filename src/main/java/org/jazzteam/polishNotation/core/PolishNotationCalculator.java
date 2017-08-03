package org.jazzteam.polishNotation.core;

public class PolishNotationCalculator {
	public Boolean searchNumber(char element) {
		char[] elements = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', '–' };
		boolean answer = false;
		for (char index : elements) {
			if (index == element) {
				answer = true;
				break;
			}
		}
		return answer;

	}

}
