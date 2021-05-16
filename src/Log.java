import java.util.Map;
/**
 * Created by Nir Yarkoni 313587057
 */

/**
 * The type Log.
 */
public class Log extends BinaryExpression implements Expression {
    /**
     * Instantiates a new Log.
     *
     * @param expressionA the expression a
     * @param expressionB the expression b
     */
    public Log(Expression expressionA, Expression expressionB) {
        super(expressionA, expressionB);
    }

    /**
     * Instantiates a new Log.
     *
     * @param stringA     the string a
     * @param expressionB the expression b
     */
    public Log(String stringA, Expression expressionB) {
        super(stringA, expressionB);
    }

    /**
     * Instantiates a new Log.
     *
     * @param expressionA the expression a
     * @param stringB     the string b
     */
    public Log(Expression expressionA, String stringB) {
        super(expressionA, stringB);
    }

    /**
     * Instantiates a new Log.
     *
     * @param stringA the string a
     * @param stringB the string b
     */
    public Log(String stringA, String stringB) {
        super(stringA, stringB);
    }

    /**
     * Instantiates a new Log.
     *
     * @param left  the left
     * @param right the right double
     */
    public Log(String left, double right) {
        super(left, right);
    }

    /**
     * Instantiates a new Log.
     *
     * @param left    the left double
     * @param stringB the string b
     */
    public Log(double left, String stringB) {
        super(left, stringB);
    }

    /**
     * Instantiates a new Log.
     *
     * @param expressionA the expression a
     * @param right       the right double
     */
    public Log(Expression expressionA, double right) {
        super(expressionA, right);
    }

    /**
     * Instantiates a new Log.
     *
     * @param left        the left double
     * @param expressionB the expression b
     */
    public Log(double left, Expression expressionB) {
        super(left, expressionB);
    }

    /**
     * Instantiates a new Log.
     *
     * @param left  the left double
     * @param right the right double
     */
    public Log(double left, double right) {
        super(left, right);
    }

    /**
     * evaluate.
     *
     * @param assignment the Map
     * @return he evaluate value of log according to the map
     * @throws Exception if contrasting the arithmetic of log
     */
    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        if ((this.getExpressionLeft().evaluate(assignment) == 1)
                || (this.getExpressionLeft().evaluate(assignment) <= 0)) {
            throw new Exception("the base of the log is one or smaller or equals to zero ");
        }
        if (this.getExpressionRight().evaluate(assignment) <= 0) {
            throw new Exception("the exponent of the log is smaller or equals to zero ");
        }
        return (Math.log(this.getExpressionRight().evaluate(assignment))
                / Math.log(this.getExpressionLeft().evaluate(assignment)));
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
        return new Log(this.getExpressionLeft().assign(var, expression),
                this.getExpressionRight().assign(var, expression));
    }

    /**
     * toString.
     *
     * @return the string formation of div
     */
    public String toString() {
        return ("log(" + this.getExpressionLeft().toString() + ", " + this.getExpressionRight().toString() + ")");
    }

    /**
     * differentiate.
     *
     * @param var the variable to differentiates with
     * @return the derivative of log
     */
    @Override
    public Expression differentiate(String var) {
        Expression firstPartDifferentiate = new Mult(new Div(1, getExpressionRight()),
                new Div(1, new Log("e", getExpressionLeft())));
        Expression secondPartDifferentiate = getExpressionLeft().differentiate(var);
        return new Mult(firstPartDifferentiate, secondPartDifferentiate);
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
            Expression leftExpression = this.getExpressionLeft();
            Expression rightExpression = this.getExpressionRight();
            //log(x/x)=1
            if (leftExpression.simplify().toString().equals(rightExpression.simplify().toString())) {
                return new Num(1.0);
            }
            return new Log(leftExpression.simplify(), rightExpression.simplify());
        }
    }
}
