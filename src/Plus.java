import java.util.Map;

public class Plus extends BinaryExpression implements Expression {

    /**
     * new Plus.
     *
     * @param expressionA the expression a
     * @param expressionB the expression b
     */
    public Plus(Expression expressionA, Expression expressionB) {
        super(expressionA, expressionB);
    }

    /**
     * new Plus.
     *
     * @param stringA     the string a
     * @param expressionB the expression b
     */
    public Plus(String stringA, Expression expressionB) {
        super(stringA, expressionB);
    }

    /**
     * new Plus.
     *
     * @param expressionA the expression a
     * @param stringB     the string b
     */
    public Plus(Expression expressionA, String stringB) {
        super(expressionA, stringB);
    }

    /**
     * new Plus.
     *
     * @param stringA the string a
     * @param stringB the string b
     */
    public Plus(String stringA, String stringB) {
        super(stringA, stringB);
    }

    /**
     * new Plus.
     *
     * @param left  the left
     * @param right the right
     */
    public Plus(String left, double right) {
        super(left, right);
    }

    /**
     * new Plus.
     *
     * @param left    the left
     * @param stringB the string b
     */
    public Plus(double left, String stringB) {
        super(left, stringB);
    }

    /**
     * new Plus.
     *
     * @param expressionA the expression a
     * @param right       the right
     */
    public Plus(Expression expressionA, double right) {
        super(expressionA, right);
    }

    /**
     * new Plus.
     *
     * @param left        the left
     * @param expressionB the expression b
     */
    public Plus(double left, Expression expressionB) {
        super(left, expressionB);
    }

    /**
     * new Plus.
     *
     * @param left  the left
     * @param right the right
     */
    public Plus(double left, double right) {
        super(left, right);
    }

    /**
     * evaluate.
     *
     * @param assignment the Map
     * @return he evaluate value of plus according to the map
     * @throws Exception if can not evaluate the variable according to Map
     */
    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return this.getExpressionLeft().evaluate(assignment) + this.getExpressionRight().evaluate(assignment);
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
        return new Plus(this.getExpressionLeft().assign(var, expression),
                this.getExpressionRight().assign(var, expression));
    }

    /**
     * toString.
     *
     * @return the string formation of plus
     */
    public String toString() {
        return "(" + this.getExpressionLeft().toString() + " + " + this.getExpressionRight().toString() + ")";
    }

    /**
     * differentiate.
     *
     * @param var the variable to differentiates with
     * @return the derivative of plus
     */
    @Override
    public Expression differentiate(String var) {
        Expression differentiateLeft = this.getExpressionLeft().differentiate(var);
        Expression differentiateRight = this.getExpressionRight().differentiate(var);
        return new Plus(differentiateLeft, differentiateRight);
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

            //x+0= x
            if (rightExpression.simplify().toString().equals("0.0")) {
                return leftExpression.simplify();
            }
            //0+x = x
            if (leftExpression.simplify().toString().equals("0.0")) {
                return rightExpression.simplify();
            }
            return new Plus(leftExpression.simplify(), rightExpression.simplify());
        }
    }
}
