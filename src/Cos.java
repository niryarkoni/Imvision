import java.util.Map;

public class Cos extends UnaryExpression implements Expression {

    /**
     * new Cos.
     *
     * @param expression
     */
    public Cos(Expression expression) {
        super(expression);
    }

    /**
     * new Cos.
     *
     * @param num
     */
    public Cos(double num) {
        super(new Num(num));
    }

    /**
     * new Cos.
     *
     * @param string the string
     */
    public Cos(String string) {
        super(new Var(string));
    }

    /**
     * evaluate.
     *
     * @param assignment the Map
     * @return the calculation of sin
     * @throws Exception if can not evaluate
     */
    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return Math.cos(Math.toRadians(this.getExpression().evaluate(assignment)));
    }

    /**
     * assign.
     * assigns the expression to the variable
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
     * @return the string formation of cos
     */
    @Override
    public String toString() {
        return "cos(" + this.getExpression().toString() + ")";
    }

    //-sinx * x'

    /**
     * differentiate.
     *
     * @param var the variable to differentiates with
     * @return the derivative of cos
     */
    @Override
    public Expression differentiate(String var) {
        return new Mult(new Neg(new Sin(this.getExpression())), this.getExpression().differentiate(var));
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
            return new Cos(expression.simplify());
        }
    }
}