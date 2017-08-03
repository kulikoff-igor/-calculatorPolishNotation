package org.jazzteam.polishNotation.core;

import java.util.List;
import java.util.Stack;

public class DecisionPolishNotation extends PolishNotationCalculator {
	public Stack<Double> lineСalculations = null;
	public String number = "";
	public double answer = 0;
	public double number1 = 0;
	public double number2 = 0;
	private final List<MathematicalExpressions> function = MathematicalExpressions.opepacii;
	private MathematicalExpressions math;

	public void readNumber1() {
		number1 = lineСalculations.elementAt(lineСalculations.size() - 1);
		lineСalculations.removeElementAt(lineСalculations.size() - 1);
	}

	public void readNumber2() {
		number2 = lineСalculations.elementAt(lineСalculations.size() - 1);
		lineСalculations.removeElementAt(lineСalculations.size() - 1);
	}

	public void findFunction(String operacia) {
		int indexFunction = 0;
		for (indexFunction = 0; indexFunction <= function.size(); indexFunction++) {
			if (function.get(indexFunction).searchFunctions(operacia) == true) {
				break;
			}
		}
		math = function.get(indexFunction);
		if (math.getType().equals("unary")) {
			unaryFunction();
		}
		if (math.getType().equals("binary")) {
			binaryFunction();
		}

	}

	public void binaryFunction() {

		readNumber1();
		readNumber2();
		lineСalculations.add(math.decisionFunction(number1, number2));

	}

	public void unaryFunction() {

		readNumber2();
		lineСalculations.add(math.decisionFunction(0, number2));
	}

	public double decisionFunction(String polishNotation) {
		lineСalculations = new Stack<Double>();
		int indexEntries = 0, compilationNumber = 0;
		for (indexEntries = 0; indexEntries < polishNotation.length(); indexEntries++) {
			if (polishNotation.charAt(indexEntries) == '[') {
				number = "";
				compilationNumber = indexEntries + 1;
				do {
					number = number + polishNotation.charAt(compilationNumber);
					compilationNumber++;
				} while (polishNotation.charAt(compilationNumber) != ']');
				try {
					lineСalculations.add(Double.parseDouble(number));
				} catch (NumberFormatException e) {
					number = "-" + number.substring(1, number.length());
					lineСalculations.add(Double.parseDouble(number));
				}
			}
			if (polishNotation.charAt(indexEntries) == '{') {

				String operation = "";
				compilationNumber = indexEntries + 1;
				do {
					operation = operation + polishNotation.charAt(compilationNumber);
					compilationNumber++;
				} while (polishNotation.charAt(compilationNumber) != '}');
				findFunction(operation);
			}
		}
		answer = lineСalculations.elementAt(0);
		return answer;

	}
}
