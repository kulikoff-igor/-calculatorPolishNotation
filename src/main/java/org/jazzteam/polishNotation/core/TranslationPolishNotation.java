package org.jazzteam.polishNotation.core;

import java.util.ArrayList;
import java.util.List;

public class TranslationPolishNotation extends PolishNotationCalculator {

	public List<MathematicalExpressions> stackTransfer = new ArrayList<MathematicalExpressions>();
	public String polishNotation = "";
	public int indexEntries;
	public int compilationNumber;
	public int priority;
	private String originalExpression;
	private MathematicalExpressions math;
	private final List<MathematicalExpressions> function = MathematicalExpressions.opepacii;

	public void number() {
		polishNotation = polishNotation + '[';
		for (compilationNumber = indexEntries; searchNumber(originalExpression.charAt(compilationNumber)) == true; compilationNumber++) {
			polishNotation = polishNotation + originalExpression.charAt(compilationNumber);
			if (compilationNumber + 1 == originalExpression.length())
				break;
		}
		polishNotation = polishNotation + ']';
		indexEntries = compilationNumber;
	}

	public void lowerPriority(String originalExpression) {
		while (true) {
			polishNotation = polishNotation + "{" + stackTransfer.get(stackTransfer.size() - 1).getName() + "}";
			stackTransfer.remove(stackTransfer.size() - 1);
			if (stackTransfer.size() == 0)
				break;
			if (math.getPrioritet() > stackTransfer.get(stackTransfer.size() - 1).getPrioritet())
				break;
		}
	}

	public void actionInParentheses() {
		do {
			compilationNumber = stackTransfer.size() - 1;
			if (stackTransfer.size() == 0)
				break;
			if (stackTransfer.get(compilationNumber).getName().equals("(")) {
				stackTransfer.remove(stackTransfer.size() - 1);
				break;
			}
			polishNotation = polishNotation + "{" + stackTransfer.get(stackTransfer.size() - 1).getName() + "}";

			stackTransfer.remove(stackTransfer.size() - 1);
			compilationNumber--;

		} while (stackTransfer.get(compilationNumber).getName().equals("("));
	}

	public void extractFromStack() {
		while (stackTransfer.size() > 0) {
			polishNotation = polishNotation + "{" + stackTransfer.get(stackTransfer.size() - 1).getName() + "}";
			stackTransfer.remove(stackTransfer.size() - 1);
		}
	}

	public boolean checkString(String string) {
		try {
			Integer.parseInt(string);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private String recognitionOperation() {
		String operation = "";
		for (int i = indexEntries; checkString(Character.toString(originalExpression.charAt(i))) == false
				&& i < originalExpression.length(); i++) {
			if (originalExpression.charAt(i) == '(' || originalExpression.charAt(i) == ')') {
				break;
			}
			operation = operation + Character.toString(originalExpression.charAt(i));
		}
		if (originalExpression.charAt(indexEntries) == '(') {
			operation = Character.toString(originalExpression.charAt(indexEntries));
		}
		if (originalExpression.charAt(indexEntries) == ')') {
			operation = Character.toString(originalExpression.charAt(indexEntries));
		}
		indexEntries += operation.length() - 1;
		return operation;
	}

	public String translateExpressions(String Expression) {
		originalExpression = Expression;
		polishNotation = "";

		for (indexEntries = 0; indexEntries < originalExpression.length(); indexEntries++) {
			if (searchNumber(originalExpression.charAt(indexEntries)) == true) {
				number();
			}
			if (checkString(Character.toString(originalExpression.charAt(indexEntries))) == false) {
				String operacia = recognitionOperation();
				math = objectCreationOperations(operacia);
				if (math != null && math.getName().equals("(") != true && math.getName().equals(")") != true) {
					if (stackTransfer.size() == 0) {
						stackTransfer.add(math);
					} else {
						if (math.getPrioritet() > stackTransfer.get(stackTransfer.size() - 1).getPrioritet()) {
							stackTransfer.add(math);
						} else {
							lowerPriority(originalExpression);
							stackTransfer.add(math);
						}

					}

				}
				if (math.getName().equals("(")) {
					stackTransfer.add(math);
				}
				if (math.getName().equals(")")) {
					actionInParentheses();
				}
			}

		}

		if (stackTransfer.size() != 0) {
			extractFromStack();
		}
		stackTransfer.clear();
		return polishNotation;
	}

	private MathematicalExpressions objectCreationOperations(String operacia) {
		int indexFunction = 0;
		for (indexFunction = 0; indexFunction <= function.size(); indexFunction++) {
			if (function.get(indexFunction).searchFunctions(operacia) == true) {
				break;
			}
		}

		return function.get(indexFunction);
	}
}
