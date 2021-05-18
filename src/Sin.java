import java.util.Map;

public class Sin extends UnaryExpression implements Expression {

    /**
     * new Sin.
     *
     * @param expression the expression
     */
    public Sin(Expression expression) {
        super(expression);
    }

    /**
     * new Sin.
     *
     * @param num the num
     */
    public Sin(double num) {
        super(new Num(num));
    }

    /**
     * new Sin.
     *
     * @param string the string
     */
    public Sin(String string) {
        super(new Var(string));
    }

    /**
     * evaluate.
     *
     * @param assignment the Map
     * @return the evaluate value of sin according to the map
     * @throws Exception if can not evaluate the variable according to Map
     */
    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return Math.sin(Math.toRadians(this.getExpression().evaluate(assignment)));
    }

    /**
     * assign.
     *
     * @param var        the current variable
     * @param expression the current expression
     * @return the assigned value
     */
    @Override
    public Expression assign(String var, Expression expression) {
        return new Sin(this.getExpression().assign(var, expression));
    }

    /**
     * toString.
     *
     * @return the string formation of sin
     */
    @Override
    public String toString() {
        return "sin(" + this.getExpression().toString() + ")";
    }

    /**
     * differentiate.
     *
     * @param var the variable to differentiates with
     * @return the derivative of sin
     */
    @Override
    public Expression differentiate(String var) {
        return new Mult(new Cos(this.getExpression()), this.getExpression().differentiate(var));
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
            return new Sin(expression.simplify());
        }
    }
}