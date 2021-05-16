import java.util.Map;
import java.util.TreeMap;

public abstract class BaseExpression implements Expression {
    /**
     * evaluate.
     * @return the value according to the Map
     * @throws Exception exception if can not evaluate
     */
    public double evaluate() throws Exception {
        Map<String, Double> assignment = new TreeMap<String, Double>();
        return this.evaluate(assignment);
    }
}


