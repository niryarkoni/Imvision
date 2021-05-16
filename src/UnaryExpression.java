import java.util.List;

public abstract class UnaryExpression extends BaseExpression implements Expression {

    private Expression expression;

    /**
     * Instantiates a new Unary expression.
     *
     * @param expressionPhrase the expression phrase
     */
    public UnaryExpression(Expression expressionPhrase) {
        this.expression = expressionPhrase;
    }

    /**
     * getVariables.
     * @return a list of variables in the expression
     */
    public List<String> getVariables() {
        return this.expression.getVariables();
    }

    /**
     * Gets expression.
     *
     * @return the expression
     */
    public Expression getExpression() {
        return this.expression;
    }
}
