package com.begin.javacc5.parser.fun;

import com.begin.javacc5.parser.*;
import com.begin.javacc5.parser.calc.AbstractNumberCalc;
import com.begin.javacc5.parser.exp.ResolvedExp;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DivideFunDef implements FunDef {

    @Override
    public String getName() {
        return "/";
    }

    @Override
    public Syntax getSyntax() {
        return Syntax.Infix;
    }

    @Override
    public Type getReturnType() {
        return Type.Number;
    }

    @Override
    public Type[] getArgsType() {
        return new Type[] {Type.Number, Type.Number};
    }

    @Override
    public Calc compile(ExpCompiler compiler, ResolvedExp resolvedExp) {
        Calc op1 = resolvedExp.getArg(0).compile(compiler);
        Calc op2 = resolvedExp.getArg(1).compile(compiler);
        return new AbstractNumberCalc() {
            @Override
            public BigDecimal evaluate(Evaluator evaluator) {

                BigDecimal v1 = (BigDecimal) op1.evaluate(evaluator);
                BigDecimal v2 = (BigDecimal) op2.evaluate(evaluator);

                return v1.divide(v2, 10, RoundingMode.HALF_UP);
            };
        };
    }
}
