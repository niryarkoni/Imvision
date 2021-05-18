import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Num implements Expression {
    private double num;

    /**
     * new Num.
     *
     * @param number the number
     */
    public Num(double number) {
        this.num = number;
    }

    /**
     * @param assignment the Map
     * @return the value of the number
     * @throws Exception if can not evaluate the number
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return this.num;
    }

    /**
     * A convenience method. Like the `evaluate(assignment)` method above,but uses an empty assignment.
     *
     * @return the value of the number
     * @throws Exception if can not evaluate the number
     */
    public double evaluate() throws Exception {
        return this.num;
    }

    /**
     * getVariables.
     * create new ArrayList
     *
     * @return a list of the variables in the expression.
     */
    public List<String> getVariables() {
        List<String> list = new ArrayList<>();
        return list;
    }

    /**
     * toString.
     *
     * @return a string representation of the expression.
     */
    public String toString() {
        if (this.num < 0) {
            return "(" + Double.toString(this.num) + ")";
        }
        return Double.toString(this.num);
    }

    /**
     * assign.
     *
     * @param var        the var
     * @param expression the expression
     * @return new expression in which all occurrences of the variable var are replaced with the provided
     * expression (Does not modify the current expression).
     */
    public Expression assign(String var, Expression expression) {
        return new Num(num);
    }

    /**
     * @param var the var
     * @return the derivative of number
     */
    @Override
    public Expression differentiate(String var) {
        return new Num(0.0);
    }

    /**
     * @return a simplified version of the current expression
     */
    @Override
    public Expression simplify() {
        return this;
    }
}
