package com.begin.javacc5.parser.exp;

import com.begin.javacc5.parser.*;

import java.util.Arrays;
import java.util.List;

public class UnresolvedExp implements Exp {

    private final String name;
    private final Syntax syntax;
    private final Exp[] args;

    public UnresolvedExp(String name, List<Exp> args) {
        this(name, Syntax.Function, args);
    }

    public UnresolvedExp(String name, Syntax syntax, List<Exp> args) {
        this(name, syntax, args.toArray(new Exp[0]));
    }

    public UnresolvedExp(String name, Exp[] args) {
        this(name, Syntax.Function, args);
    }

    public UnresolvedExp(String name, Syntax syntax, Exp[] args) {
        this.name = name;
        this.syntax = syntax;
        this.args = args;
    }

    @Override
    public Exp validate(Validator validator) {
        Exp[] newArgs = new Exp[args.length]; // resolved args
        for (int i=0; i<args.length; i++) {
            newArgs[i] = validator.validate(args[i]);
        }

        FunDef funDef = validator.getFunDef(syntax, name, newArgs);
        return new ResolvedExp(funDef, newArgs);
    }

    @Override
    public Calc compile(ExpCompiler compiler) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "UnresolvedFunCall{" +
                "name='" + name + '\'' +
                ", syntax=" + syntax +
                ", args=" + Arrays.toString(args) +
                '}';
    }
}

