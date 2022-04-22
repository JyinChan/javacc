package com.begin.javacc5.parser;

import com.begin.javacc5.parser.fun.*;

public class ValidatorImpl implements Validator {

    @Override
    public Exp validate(Exp exp) {
        return exp.validate(this);
    }

    @Override
    public FunDef getFunDef(Syntax syntax, String name, Exp[] args) {
        if (name.equals("sum")) {
            return new SumFunDef();
        }

        if (name.equals("+")) {
            return new PlusFunDef();
        }

        if (name.equals("-") && syntax == Syntax.Infix) {
            return new SubtractFunDef();
        }

        if (name.equals("*")) {
            return new TimesFunDef();
        }

        if (name.equals(("/"))) {
            return new DivideFunDef();
        }

        if (name.equals("-") && syntax == Syntax.Prefix) {
            return new MinusFunDef();
        }

        throw new RuntimeException("No FunDef name:" + name);
    }
}
