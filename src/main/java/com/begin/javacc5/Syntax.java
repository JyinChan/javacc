public enum Syntax {
    /**
     * Defines syntax for expression invoked <code>FUNCTION()</code> or
     * <code>FUNCTION(args)</code>.
     */
    Function,

    /**
     * Defines syntax for expression invoked as <code>arg OPERATOR arg</code>
     * (like '+' or 'AND').
     */
    Infix,

    /**
     * Defines syntax for expression invoked as <code>OPERATOR arg</code>
     * (like unary '-').
     */
    Prefix,

    Var,

    IF,

}
