package com.begin.javacc5.parser.calc;

import com.begin.javacc5.parser.Calc;
import com.begin.javacc5.parser.Evaluator;

import java.math.BigDecimal;

public interface NumberCalc extends Calc {

    @Override
    BigDecimal evaluate(Evaluator evaluator);
}
