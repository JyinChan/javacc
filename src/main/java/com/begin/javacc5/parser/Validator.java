package com.begin.javacc5.parser;

public interface Validator {

    Exp validate(Exp exp);

    FunDef getFunDef(Syntax syntax, String name, Exp[] args);
}
