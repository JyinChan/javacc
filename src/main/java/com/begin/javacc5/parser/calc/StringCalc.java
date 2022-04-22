package com.begin.javacc5.parser.calc;

import com.begin.javacc5.parser.Calc;
import com.begin.javacc5.parser.Evaluator;

public interface StringCalc extends Calc {

    @Override
    String evaluate(Evaluator evaluator);
}
