import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Var implements Expression {
    private String var;

    /**
     * new Var.
     *
     * @param variable the variable
     */
    public Var(String variable) {
        this.var = variable;
    }

    /**
     * @param assignment the Map
     * @return the value of the var according to the Map
     * @throws Exception if can not evaluate it
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        if (assignment.containsKey(this.var)) {
            return assignment.get(this.var);
        } else {
            throw new Exception("You need assign a value to a var " + this.var);
        }
    }

    /**
     * A convenience method. Like the `evaluate(assignment)` method above,but uses an empty assignment.
     * @return exception
     * @throws Exception there is no Map to compare with
     */
    public double evaluate() throws Exception {
        throw new Exception("You need assign a value to a var " + this.var);
    }

    /**
     * getVariables.
     * create new ArrayList
     *
     * @return a list of the variables in the expression.
     */
    public List<String> getVariables() {
        List<String> list = new ArrayList<>();
        list.add(this.var);
        return list;
    }

    /**
     * toString.
     *
     * @return a string representation of the expression.
     */
    public String toString() {
        return this.var;
    }

    /**
     * assign.
     *
     * @param variable        the var
     * @param expression the expression
     * @return expression that contain the var
     */
    public Expression assign(String variable, Expression expression) {
        if (this.var.equals(variable)) {
            return expression;
        } else {
            return this;
        }
    }

    /**
     * @param variable the var
     * @return the derivative of variable
     */
    @Override
    public Expression differentiate(String variable) {
        if (this.var.equals(variable)) {
            return new Num(1.0);
        } else {
            return new Num(0.0);
        }
    }

    /**
     * @return a simplified version of the current expression
     */
    @Override
    public Expression simplify() {
        return this;
    }
}
