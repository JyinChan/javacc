package com.begin.javacc5.parser.calc;

public abstract class AbstractStringCalc implements StringCalc {

    protected String val;

    public AbstractStringCalc(String val) {
        this.val = val;
    }
}
