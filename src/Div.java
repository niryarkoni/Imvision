import java.util.Map;

public class Div extends BinaryExpression implements Expression {
    /**
     * new Div.
     *
     * @param expressionA the expression a
     * @param expressionB the expression b
     */
    public Div(Expression expressionA, Expression expressionB) {
        super(expressionA, expressionB);
    }

    /**
     * new Div.
     *
     * @param stringA     the string a
     * @param expressionB the expression b
     */
    public Div(String stringA, Expression expressionB) {
        super(stringA, expressionB);
    }

    /**
     *  new Div.
     *
     * @param expressionA the expression a
     * @param stringB     the string b
     */
    public Div(Expression expressionA, String stringB) {
        super(expressionA, stringB);
    }

    /**
     * new Div.
     *
     * @param stringA the string a
     * @param stringB the string b
     */
    public Div(String stringA, String stringB) {
        super(stringA, stringB);
    }

    /**
     * new Div.
     *
     * @param left  the left double
     * @param right the right double
     */
    public Div(String left, double right) {
        super(left, right);
    }

    /**
     * new Div.
     *
     * @param left    the left
     * @param stringB the string b
     */
    public Div(double left, String stringB) {
        super(left, stringB);
    }

    /**
     * new Div.
     *
     * @param expressionA the expression a
     * @param right       the right double
     */
    public Div(Expression expressionA, double right) {
        super(expressionA, right);
    }

    /**
     * new Div.
     *
     * @param left        the left double
     * @param expressionB the expression b
     */
    public Div(double left, Expression expressionB) {
        super(left, expressionB);
    }

    /**
     * new Div.
     *
     * @param left  the left double
     * @param right the right double
     */
    public Div(double left, double right) {
        super(left, right);
    }

    /**
     * evaluate.
     *
     * @param assignment the Map
     * @return evaluates value of div according to the map
     * @throws Exception if can not evaluate the variable according to Map
     */
    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        if (this.getExpressionRight().evaluate(assignment) == 0) {
            throw new Exception("This is not possible to divide in zero");
        }
        return (this.getExpressionLeft().evaluate(assignment) / this.getExpressionRight().evaluate(assignment));
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
        return new Div(this.getExpressionLeft().assign(var, expression),
                this.getExpressionRight().assign(var, expression));
    }

    /**
     * toString.
     *
     * @return the string formation of div
     */
    public String toString() {
        return "(" + this.getExpressionLeft().toString() + " / " + this.getExpressionRight().toString() + ")";
    }

    /**
     * differentiate.
     *
     * @param var the variable to differentiates with
     * @return the derivative of div
     */
    @Override
    public Expression differentiate(String var) {
        Expression multLeft = new Mult(getExpressionLeft().differentiate(var), getExpressionRight());
        Expression multRight = new Mult(getExpressionLeft(), getExpressionRight().differentiate(var));
        return new Div(new Minus(multLeft, multRight), new Pow(getExpressionRight(), 2));
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
            // x/x=1
            if (leftExpression.simplify().toString().equals(rightExpression.simplify().toString())) {
                return new Num(1.0);
            }
            // x/1 =x
            if (rightExpression.simplify().toString().equals("1.0")) {
                return leftExpression.simplify();
            }
            return new Div(leftExpression.simplify(), rightExpression.simplify());
        }
    }
}
