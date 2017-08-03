package org.jazzteam.polishNotation.core;

public class OpenBracket implements MathematicalExpressions {
	final public int prioritet = 1;
	final public String name = "(";

	@Override
	public double decisionFunction(double number1, double number2) {
		return 0;
	}

	@Override
	public boolean searchFunctions(String function) {
		boolean answer = false;
		String fun = "(";
		if (fun.equals(function)) {
			answer = true;
		}
		return answer;
	}

	@Override
	public String getName() {

		return this.name;
	}

	@Override
	public Integer getPrioritet() {

		return this.prioritet;
	}

	@Override
	public String getType() {
		return null;
	}

}
