package org.jazzteam.polishNotation.core;

class Sin implements MathematicalExpressions {
	final public int prioritet = 5;
	final private String name = "sin";
	final private String type = "unary";

	@Override
	public double decisionFunction(double number1, double number2) {
		return (Math.sin(Math.toRadians(number2)));
	}

	@Override
	public boolean searchFunctions(String function) {
		boolean answer = false;
		String fun = "sin";
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