package com.begin.javacc5.parser.fun;

import com.begin.javacc5.parser.*;
import com.begin.javacc5.parser.calc.AbstractNumberCalc;
import com.begin.javacc5.parser.exp.ResolvedExp;

import java.math.BigDecimal;

public class MinusFunDef implements FunDef {

    @Override
    public String getName() {
        return "-";
    }

    @Override
    public Syntax getSyntax() {
        return Syntax.Prefix;
    }

    @Override
    public Type getReturnType() {
        return Type.Number;
    }

    @Override
    public Type[] getArgsType() {
        return new Type[] {Type.Number};
    }

    @Override
    public Calc compile(ExpCompiler compiler, ResolvedExp resolvedExp) {
        Calc op = resolvedExp.getArg(0).compile(compiler);
        return new AbstractNumberCalc() {
            @Override
            public BigDecimal evaluate(Evaluator evaluator) {

                BigDecimal v = (BigDecimal) op.evaluate(evaluator);
                return  v.multiply(new BigDecimal("-1"));
            };
        };
    }
}
