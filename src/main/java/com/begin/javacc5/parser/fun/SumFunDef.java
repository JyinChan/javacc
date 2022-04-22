package com.begin.javacc5.parser.fun;

import com.begin.javacc5.parser.*;
import com.begin.javacc5.parser.calc.AbstractNumberCalc;
import com.begin.javacc5.parser.exp.ResolvedExp;

import java.math.BigDecimal;

public class SumFunDef implements FunDef {

    @Override
    public String getName() {
        return "sum";
    }

    @Override
    public Syntax getSyntax() {
        return Syntax.Function;
    }

    @Override
    public Type getReturnType() {
        return Type.Number;
    }

    @Override
    public Type[] getArgsType() {
        return new Type[] { Type.Numbers };
    }

    @Override
    public Calc compile(ExpCompiler compiler, ResolvedExp resolvedExp) {
        Exp[] args = resolvedExp.getArgs();
        Calc[] calcs = new Calc[args.length];
        for (int i=0; i<args.length; i++) {
            Calc c = args[i].compile(compiler);
            calcs[i] = c;
        }

        return new AbstractNumberCalc() {
            @Override
            public BigDecimal evaluate(Evaluator evaluator) {
                BigDecimal sum = new BigDecimal("0");
                for (Calc c : calcs) {
                    BigDecimal s = (BigDecimal) c.evaluate(evaluator);
                    sum = sum.add(s);
                }
                return sum;
            }
        };

    }
}
