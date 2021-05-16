import java.util.Map;

public class Mult extends BinaryExpression implements Expression {
    /**
     * Instantiates a new Mult.
     *
     * @param expressionA the expression a
     * @param expressionB the expression b
     */
    public Mult(Expression expressionA, Expression expressionB) {
        super(expressionA, expressionB);
    }

    /**
     * Instantiates a new Mult.
     *
     * @param stringA     the string a
     * @param expressionB the expression b
     */
    public Mult(String stringA, Expression expressionB) {
        super(stringA, expressionB);
    }

    /**
     * Instantiates a new Mult.
     *
     * @param expressionA the expression a
     * @param stringB     the string b
     */
    public Mult(Expression expressionA, String stringB) {
        super(expressionA, stringB);
    }

    /**
     * Instantiates a new Mult.
     *
     * @param stringA the string a
     * @param stringB the string b
     */
    public Mult(String stringA, String stringB) {
        super(stringA, stringB);
    }

    /**
     * Instantiates a new Mult.
     *
     * @param left  the left
     * @param right the right
     */
    public Mult(String left, double right) {
        super(left, right);
    }

    /**
     * Instantiates a new Mult.
     *
     * @param left    the left
     * @param stringB the string b
     */
    public Mult(double left, String stringB) {
        super(left, stringB);
    }

    /**
     * Instantiates a new Mult.
     *
     * @param expressionA the expression a
     * @param right       the right
     */
    public Mult(Expression expressionA, double right) {
        super(expressionA, right);
    }

    /**
     * Instantiates a new Mult.
     *
     * @param left        the left
     * @param expressionB the expression b
     */
    public Mult(double left, Expression expressionB) {
        super(left, expressionB);
    }

    /**
     * Instantiates a new Mult.
     *
     * @param left  the left
     * @param right the right
     */
    public Mult(double left, double right) {
        super(left, right);
    }

    /**
     * evaluate.
     *
     * @param assignment the Map
     * @return he evaluate value of mult according to the map
     * @throws Exception if can not evaluate the variable according to Map
     */
    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return (this.getExpressionLeft().evaluate(assignment) * this.getExpressionRight().evaluate(assignment));
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
        return new Mult(this.getExpressionLeft().assign(var, expression),
                this.getExpressionRight().assign(var, expression));
    }

    /**
     * toString.
     *
     * @return the string formation of mult
     */
    public String toString() {
        return "(" + this.getExpressionLeft().toString() + " * " + this.getExpressionRight().toString() + ")";
    }

    /**
     * differentiate.
     *
     * @param var the variable to differentiates with
     * @return the derivative of mult
     */
    @Override
    public Expression differentiate(String var) {
        Expression multLeft = new Mult(getExpressionLeft().differentiate(var), getExpressionRight());
        Expression multRight = new Mult(getExpressionLeft(), getExpressionRight().differentiate(var));
        return new Plus(multLeft, multRight);
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
            //1*x
            if (leftExpression.simplify().toString().equals("1.0")) {
                return rightExpression.simplify();
            }
            //x*1
            if (rightExpression.simplify().toString().equals("1.0")) {
                return leftExpression.simplify();
            }
            //x*0 or 0*x = 0
            if (leftExpression.simplify().toString().equals("0.0")
                    || rightExpression.simplify().toString().equals("0.0")) {
                return new Num(0.0);
            }
            return new Mult(leftExpression.simplify(), rightExpression.simplify().simplify());
        }
    }
}
