
import java.util.ArrayList;
import java.util.List;

public class FunCall {

    public Token fun;
    public List<Object> args = new ArrayList<>();

    public double call(Evaluator evaluator) {

        if ("sum".equals(fun.image)) {
            double sum = 0;
            for (Object arg : args) {
                if (arg instanceof Token) {
                    Token t = (Token) arg;
                    double a = 0;
                    if (t.kind == CalculatorConstants.NUMBER) {
                        a = Double.parseDouble(t.image);
                    }
                    else if (t.kind == CalculatorConstants.VAR) {
                        a = evaluator.getVar(t.image);
                    }
                    sum += a;
                }
                else if (arg instanceof FunCall) {
                    double a = ((FunCall) arg).call(evaluator);
                    sum += a;
                }
                else {
                    throw new RuntimeException("No such type:" + arg);
                }
            }

            return sum;
        }

        throw new RuntimeException("No such function name:" + fun.image);
    }



    @Override
    public String toString() {
        return "FunCall{" +
                "fun=" + fun +
                ", args=" + args +
                '}';
    }
}
