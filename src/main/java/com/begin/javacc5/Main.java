package com.begin.javacc5;

import com.begin.javacc5.parser.*;
import com.begin.javacc5.parser.generated.MyParser;

public class Main {

    public static void main(String[] args) throws Exception {

        MyParser myParser = new MyParser(System.in);
        Exp exp = myParser.start();

        Exp validateExp = exp.validate(new ValidatorImpl());

        Calc calc = validateExp.compile(new ExpCompiler() {
        });

        Object o = calc.evaluate(new Evaluator() {
        });

        System.out.println(o);
    }
}
