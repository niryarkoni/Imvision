import java.util.Map;

public class Neg extends UnaryExpression implements Expression {

    /**
     * new Neg.
     *
     * @param expression the expression
     */
    public Neg(Expression expression) {
        super(expression);
    }

    /**
     * new Neg.
     *
     * @param num the num
     */
    public Neg(double num) {
        super(new Num(num));
    }

    /**
     * new Neg.
     *
     * @param string the string
     */
    public Neg(String string) {
        super(new Var(string));
    }

    /**
     * evaluate.
     *
     * @param assignment the Map
     * @return he evaluate value of neg according to the map
     * @throws Exception if can not evaluate the variable according to Map
     */
    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return -(this.getExpression().evaluate(assignment));
    }

    /**
     * assign.
     *
     * @param var        the current variable
     * @param expression the current expression
     * @return the assigned value according to var and expression
     */
    @Override
    public Expression assign(String var, Expression expression) {
        return new Neg(this.getExpression().assign(var, expression));
    }

    /**
     * toString.
     *
     * @return the string formation of neg
     */
    @Override
    public String toString() {
        return "(-" + this.getExpression().toString() + ")";
    }

    /**
     * differentiate.
     *
     * @param var the variable to differentiates with
     * @return the derivative of minus
     */
    @Override
    public Expression differentiate(String var) {
        return new Mult(new Num(-1.0),
                getExpression().differentiate(var));
    }

    /**
     * simplify.
     *
     * @return simplified version of the expression
     */
    @Override
    public Expression simplify() {
        try {
            return new Num(this.evaluate());
        } catch (Exception exception) {
            Expression expression = this.getExpression();
            return new Neg(expression.simplify());
        }
    }
}
