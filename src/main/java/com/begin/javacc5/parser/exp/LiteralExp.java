package com.begin.javacc5.parser.exp;

import com.begin.javacc5.parser.*;
import com.begin.javacc5.parser.calc.AbstractNumberCalc;
import com.begin.javacc5.parser.calc.AbstractStringCalc;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LiteralExp implements Exp {

    private int type; // 0:string 1:number
    private Object value;
    private LiteralExp(Object value, int type) {
        this.type = type;
        this.value = value;
    }

    private static final Map<String, LiteralExp> literalMap = new ConcurrentHashMap<>();

    public static LiteralExp createString(String s) {
        return literalMap.computeIfAbsent(s, k -> new LiteralExp(s, 0));
    }

    public static LiteralExp createNumber(String s) {
        return literalMap.computeIfAbsent(s, k -> new LiteralExp(new BigDecimal(s), 1));
    }

    @Override
    public Exp validate(Validator validator) {
        return this;
    }

    @Override
    public Calc compile(ExpCompiler compiler) {
        if (type == 0) {
            return new AbstractStringCalc((String) value) {
                @Override
                public String evaluate(Evaluator evaluator) {
                    return this.val;
                }
            };
        }

        if (type == 1) {
            return new AbstractNumberCalc((BigDecimal) value) {
                @Override
                public Object evaluate(Evaluator evaluator) {
                    return this.val;
                }
            };
        }

        throw new IllegalStateException("Unexpected Literal type:" + type);
    }

    @Override
    public String toString() {
        return "Literal{" +
                "type=" + type +
                ", value=" + value +
                '}';
    }
}
