package org.jazzteam.polishNotation.core;

class Log implements MathematicalExpressions {

	final public int prioritet = 5;
	final private String name = "ln";
	final private String type = "unary";

	@Override
	public double decisionFunction(double number1, double number2) {
		return (Math.log(number2));
	}

	@Override
	public boolean searchFunctions(String function) {
		boolean answer = false;
		String fun = "ln";
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