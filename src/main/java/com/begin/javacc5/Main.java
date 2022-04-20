
public class Main {

    public static void main(String[] args) throws Exception {
        Calculator parser = new Calculator( System.in ) ;
        FunCall fun = parser.Start( System.out ) ;
        Evaluator evaluator = new Evaluator();
        evaluator.addVar("[x]", 100);
        evaluator.addVar("[y]", 201);
        double result = fun.call(evaluator);
        System.out.println(result);
    }
}
