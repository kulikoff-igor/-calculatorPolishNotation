package org.jazzteam.polishNotation.core;

class Add implements MathematicalExpressions {
	final public int prioritet = 2;
	final private String name = "+";
	final private String type = "binary";

	@Override
	public double decisionFunction(double number1, double number2) {
		return (number2 + number1);
	}

	@Override
	public boolean searchFunctions(String function) {
		boolean answer = false;
		String fun = "+";
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
		return type;
	}
}