
import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Literal implements Exp {

    private int type; // 0:string 1:number
    private Object value;
    private Literal(Object value, int type) {
        this.type = type;
        this.value = value;
    }

    private static final Map<String, Literal> literalMap = new ConcurrentHashMap<>();


    public static Literal createString(String s) {
        return literalMap.computeIfAbsent(s, k -> new Literal(s, 0));
    }

    public static Literal createNumber(String s) {
        return literalMap.computeIfAbsent(s, k -> new Literal(new BigDecimal(s), 1));
    }

    @Override
    public String toString() {
        return "Literal{" +
                "type=" + type +
                ", value=" + value +
                '}';
    }
}
