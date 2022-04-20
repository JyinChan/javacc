import java.util.ArrayList;
import java.util.List;

public class FunCall {

    public Token fun;
    public List<Object> args = new ArrayList<>();

    @Override
    public String toString() {
        return "FunCall{" +
                "fun=" + fun +
                ", args=" + args +
                '}';
    }
}
