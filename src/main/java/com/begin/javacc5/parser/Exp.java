package com.begin.javacc5.parser;

public interface Exp {

    Exp validate(Validator validator);

    Calc compile(ExpCompiler compiler);

}