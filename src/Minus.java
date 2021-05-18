    import java.util.Map;

public class Minus extends BinaryExpression implements Expression {
    /**
     * new Minus.
     *
     * @param expressionA the expression a
     * @param expressionB the expression b
     */
    public Minus(Expression expressionA, Expression expressionB) {
        super(expressionA, expressionB);
    }

    /**
     * new Minus.
     *
     * @param stringA     the string a
     * @param expressionB the expression b
     */
    public Minus(String stringA, Expression expressionB) {
        super(stringA, expressionB);
    }

    /**
     * new Minus.
     *
     * @param expressionA the expression a
     * @param stringB     the string b
     */
    public Minus(Expression expressionA, String stringB) {
        super(expressionA, stringB);
    }

    /**
     * new Minus.
     *
     * @param stringA the string a
     * @param stringB the string b
     */
    public Minus(String stringA, String stringB) {
        super(stringA, stringB);
    }

    /**
     * new Minus.
     *
     * @param left  the left
     * @param right the right
     */
    public Minus(String left, double right) {
        super(left, right);
    }

    /**
     * new Minus.
     *
     * @param left    the left
     * @param stringB the string b
     */
    public Minus(double left, String stringB) {
        super(left, stringB);
    }

    /**
     * new Minus.
     *
     * @param expressionA the expression a
     * @param right       the right
     */
    public Minus(Expression expressionA, double right) {
        super(expressionA, right);
    }

    /**
     * new Minus.
     *
     * @param left        the left
     * @param expressionB the expression b
     */
    public Minus(double left, Expression expressionB) {
        super(left, expressionB);
    }

    /**
     * new Minus.
     *
     * @param left  the left
     * @param right the right
     */
    public Minus(double left, double right) {
        super(left, right);
    }

    /**
     * evaluate.
     *
     * @param assignment the Map
     * @return he evaluate value of minus according to the map
     * @throws Exception if can not evaluate the variable according to Map
     */
    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return this.getExpressionLeft().evaluate(assignment) - this.getExpressionRight().evaluate(assignment);
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
        return new Minus(this.getExpressionLeft().assign(var, expression),
                this.getExpressionRight().assign(var, expression));
    }

    /**
     * toString.
     *
     * @return the string formation of div
     */
    public String toString() {
        return "(" + this.getExpressionLeft().toString() + " - " + this.getExpressionRight().toString() + ")";
    }

    /**
     * differentiate.
     *
     * @param var the variable to differentiates with
     * @return the derivative of minus
     */
    @Override
    public Expression differentiate(String var) {
        return new Minus(getExpressionLeft().differentiate(var), getExpressionRight().differentiate(var));
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
            //x-0= x
            if (rightExpression.simplify().toString().equals("0.0")) {
                return leftExpression.simplify();
            }
            //0-x = -x
            if (leftExpression.simplify().toString().equals("0.0")) {
                return new Neg(rightExpression.simplify());
            }
            //x-x =0
            if (leftExpression.simplify().toString().equals(rightExpression.simplify().toString())) {
                return new Num(0.0);
            }
            return new Minus(leftExpression.simplify(), rightExpression.simplify());
        }
    }
}
