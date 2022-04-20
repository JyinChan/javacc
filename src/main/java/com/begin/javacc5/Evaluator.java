
import java.util.HashMap;
import java.util.Map;

public class Evaluator {

    private Map<String, Integer> varTable = new HashMap<>();

    public void addVar(String key, int val) {
        varTable.put(key, val);
    }

    public Integer getVar(String key) {
        return varTable.get(key);
    }
}
