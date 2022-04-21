
import java.util.Arrays;
import java.util.List;

public class UnresolvedFunCall implements Exp {

    private final String name;
    private final Syntax syntax;
    private final Exp[] args;

    public UnresolvedFunCall(String name, List<Exp> args) {
        this(name, Syntax.Function, args);
    }

    public UnresolvedFunCall(String name, Syntax syntax, List<Exp> args) {
        this(name, syntax, args.toArray(new Exp[0]));

    public UnresolvedFunCall(String name, Exp[] args) {
        this(name, Syntax.Function, args);
    }

    public UnresolvedFunCall(String name, Syntax syntax, Exp[] args) {
        this.name = name;
        this.syntax = syntax;
        this.args = args;
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

