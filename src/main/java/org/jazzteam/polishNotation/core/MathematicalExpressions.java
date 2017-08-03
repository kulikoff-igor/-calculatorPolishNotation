package org.jazzteam.polishNotation.core;

import java.util.Arrays;
import java.util.List;

public interface MathematicalExpressions {

	final static List<MathematicalExpressions> opepacii = Arrays.asList(new Sin(), new Cos(), new Add(),
			new CloseBracket(), new OpenBracket(), new Pow(), new Sqrt(), new Mul(), new Div(), new Sub(), new Log());

	public double decisionFunction(double number1, double number2);

	public String getName();

	public Integer getPrioritet();

	public boolean searchFunctions(String function);

	public String getType();
}