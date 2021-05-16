import java.util.Map;

public class Pow extends BinaryExpression implements Expression {
    /**
     * Instantiates a new Pow.
     *
     * @param expressionA the expression a
     * @param expressionB the expression b
     */
    public Pow(Expression expressionA, Expression expressionB) {
        super(expressionA, expressionB);
    }

    /**
     * Instantiates a new Pow.
     *
     * @param stringA     the string a
     * @param expressionB the expression b
     */
    public Pow(String stringA, Expression expressionB) {
        super(stringA, expressionB);
    }

    /**
     * Instantiates a new Pow.
     *
     * @param expressionA the expression a
     * @param stringB     the string b
     */
    public Pow(Expression expressionA, String stringB) {
        super(expressionA, stringB);
    }

    /**
     * Instantiates a new Pow.
     *
     * @param stringA the string a
     * @param stringB the string b
     */
    public Pow(String stringA, String stringB) {
        super(stringA, stringB);
    }

    /**
     * Instantiates a new Pow.
     *
     * @param left  the left
     * @param right the right
     */
    public Pow(String left, double right) {
        super(left, right);
    }

    /**
     * Instantiates a new Pow.
     *
     * @param left    the left
     * @param stringB the string b
     */
    public Pow(double left, String stringB) {
        super(left, stringB);
    }

    /**
     * Instantiates a new Pow.
     *
     * @param expressionA the expression a
     * @param right       the right
     */
    public Pow(Expression expressionA, double right) {
        super(expressionA, right);
    }

    /**
     * Instantiates a new Pow.
     *
     * @param left        the left
     * @param expressionB the expression b
     */
    public Pow(double left, Expression expressionB) {
        super(left, expressionB);
    }

    /**
     * Instantiates a new Pow.
     *
     * @param left  the left
     * @param right the right
     */
    public Pow(double left, double right) {
        super(left, right);
    }

    /**
     * evaluate.
     *
     * @param assignment the Map
     * @return he evaluate value of pow according to the map
     * @throws Exception if can not evaluate the variable according to Map
     */
    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return Math.pow(this.getExpressionLeft().evaluate(assignment), this.getExpressionRight().evaluate(assignment));
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
        return new Pow(this.getExpressionLeft().assign(var, expression),
                this.getExpressionRight().assign(var, expression));
    }

    /**
     * toString.
     *
     * @return the string formation of plus
     */
    public String toString() {
        return "(" + this.getExpressionLeft().toString() + "^" + this.getExpressionRight().toString() + ")";
    }

    /**
     * differentiate.
     *
     * @param var the variable to differentiates with
     * @return the derivative of pow
     */
    @Override
    public Expression differentiate(String var) {
        return new Mult(new Pow(getExpressionLeft(), getExpressionRight()),
                new Plus(new Mult(getExpressionLeft().differentiate(var),
                        new Div(getExpressionRight(), getExpressionLeft())),
                        new Mult(getExpressionRight().differentiate(var),
                                new Log("e", getExpressionLeft()))));
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
            return new Pow(leftExpression.simplify(), rightExpression.simplify());
        }
    }
}

