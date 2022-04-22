package com.begin.javacc5.parser;

import com.begin.javacc5.parser.exp.ResolvedExp;

public interface FunDef {

    String getName();

    Syntax getSyntax();

    Type getReturnType();

    Type[] getArgsType();

    Calc compile(ExpCompiler compiler, ResolvedExp resolvedExp);
}
