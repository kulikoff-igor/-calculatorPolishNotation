package org.jazzteam.polishNotation.core;

import java.util.Arrays;
import java.util.List;

public class ValidatorPolishNotation {
	public List<String> errors = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "(", ")", "+", "-",
			"*", "/", "c", "o", "s", "i", "n", "l", "g", "^", "√", ".", "–");

	public boolean check(String originalExpression) {

		int indexEntries, numberOfBrackets = 0;
		int bug = 0;
		for (indexEntries = 0; indexEntries < originalExpression.length(); indexEntries++) {
			if (check(indexEntries, originalExpression) == true) {
				bug++;
			}
			if (originalExpression.charAt(indexEntries) == '(' || originalExpression.charAt(indexEntries) == ')') {
				numberOfBrackets++;
			}
		}
		if (bug == 0 && numberOfBrackets % 2 == 0) {
			return true;
		} else {
			return false;
		}

	}

	public boolean check(int element, String originalExpression) {
		boolean answer = true;
		if (errors.contains(Character.toString(originalExpression.charAt(element))) == true) {
			answer = false;
		}
		return answer;
	}
}
