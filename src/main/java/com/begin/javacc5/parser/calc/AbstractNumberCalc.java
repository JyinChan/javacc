package com.begin.javacc5.parser.calc;

import com.begin.javacc5.parser.Calc;

import java.math.BigDecimal;

public abstract class AbstractNumberCalc implements Calc {

    protected BigDecimal val;

    public AbstractNumberCalc() {
        this("0");
    }

    public AbstractNumberCalc(String num) {
        this(new BigDecimal(num));
    }

    public AbstractNumberCalc(BigDecimal num) {
        this.val = num;
    }

}
