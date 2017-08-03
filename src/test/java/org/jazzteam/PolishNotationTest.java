package org.jazzteam;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.jazzteam.polishNotation.core.DecisionPolishNotation;
import org.jazzteam.polishNotation.core.TranslationPolishNotation;
import org.jazzteam.polishNotation.core.ValidatorPolishNotation;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PolishNotationTest {
	@Test
	public void test() {
		TranslationPolishNotation q = new TranslationPolishNotation();
		assertEquals("[50][2][1]{-}{sin}{cos}{+}[5][3]{+}{*}", q.translateExpressions("(50+(cos(sin(2-1))))*(5+3)"));
        System.out.println(q.translateExpressions("(1+2*3*(4-5*6)^7+9*0)/(10*11+12*13/14-15*16*17+18)"));
        Map<String, Integer> hm = new HashMap<String, Integer>();

// Помещаем данные на карточку
        hm.put("Васька", new Integer(5));
        hm.put("Мурзик", new Integer(8));
        hm.put("Рыжик", new Integer(12));
        hm.put("Барсик", new Integer(5));

    }

	@Test
	public void test_resh() {
		DecisionPolishNotation q = new DecisionPolishNotation();
		assertTrue(47.9999996288706 == q.decisionFunction("[5][2][1]{-}{sin}{cos}{+}[5][3]{+}{*}"));

	}

	@Test
	public void test_prov() {
		ValidatorPolishNotation q = new ValidatorPolishNotation();
		assertFalse(q.check("(5(cos(sin(2-1)))*(5+3)"));
		assertTrue(q.check("((cos(60)+(sin(45)))*6)/5"));
	}

}
