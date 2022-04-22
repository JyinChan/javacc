package com.begin.javacc5.parser.exp;

import com.begin.javacc5.parser.*;

public class ResolvedExp implements Exp {

    private FunDef funDef;
    private Exp[] args;

    public ResolvedExp(FunDef funDef, Exp[] args) {
        this.funDef = funDef;
        this.args = args;
    }

    @Override
    public Exp validate(Validator validator) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Calc compile(ExpCompiler compiler) {
        return funDef.compile(compiler, this);
    }

    public Exp[] getArgs() {
        return args;
    }

    public Exp getArg(int index) {
        return args[index];
    }
}
