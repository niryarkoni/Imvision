import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public abstract class BinaryExpression extends BaseExpression implements Expression {
    //the left expression
    private Expression expressionLeft;
    //the right expression
    private Expression expressionRight;

    /**
     * new Binary expression.
     *
     * @param expressionPhraseLeft  the expression phrase left
     * @param expressionPhraseRight the expression phrase right
     */
    public BinaryExpression(Expression expressionPhraseLeft, Expression expressionPhraseRight) {
        this.expressionLeft = expressionPhraseLeft;
        this.expressionRight = expressionPhraseRight;
    }

    /**
     * new Binary expression.
     *
     * @param left  the left
     * @param right the right
     */
    public BinaryExpression(String left, String right) {
        this.expressionLeft = new Var(left);
        this.expressionRight = new Var(right);
    }

    /**
     * new Binary expression.
     *
     * @param expressionPhraseLeft the expression phrase left
     * @param right                the right string
     */
    public BinaryExpression(Expression expressionPhraseLeft, String right) {
        this.expressionLeft = expressionPhraseLeft;
        this.expressionRight = new Var(right);
    }

    /**
     * new Binary expression.
     *
     * @param left  the left string
     * @param right the right double
     */
    public BinaryExpression(String left, double right) {
        this.expressionLeft = new Var(left);
        this.expressionRight = new Num(right);
    }

    /**
     * new Binary expression.
     *
     * @param left                  the left string
     * @param expressionPhraseRight the expression phrase right
     */
    public BinaryExpression(String left, Expression expressionPhraseRight) {
        this.expressionLeft = new Var(left);
        this.expressionRight = expressionPhraseRight;
    }

    /**
     * new Binary expression.
     *
     * @param left  the left double
     * @param right the right string
     */
    public BinaryExpression(double left, String right) {
        this.expressionLeft = new Num(left);
        this.expressionRight = new Var(right);
    }

    /**
     * new Binary expression.
     *
     * @param left  the left double
     * @param right the right double
     */
    public BinaryExpression(double left, double right) {
        this.expressionLeft = new Num(left);
        this.expressionRight = new Num(right);
    }

    /**
     * new Binary expression.
     *
     * @param left                  the left double
     * @param expressionPhraseRight the expression phrase right
     */
    public BinaryExpression(double left, Expression expressionPhraseRight) {
        this.expressionLeft = new Num(left);
        this.expressionRight = expressionPhraseRight;
    }

    /**
     * new Binary expression.
     *
     * @param expressionPhraseLeft the expression phrase left
     * @param left                 the left double
     */
    public BinaryExpression(Expression expressionPhraseLeft, double left) {
        this.expressionLeft = expressionPhraseLeft;
        this.expressionRight = new Num(left);
    }

    /**
     * name:getVariables.
     * create a list of variables using set to avoid duplicates
     * @return the list of variables
     */
    public List<String> getVariables() {
        List<String> listVariables = new ArrayList<String>();
        Set<String> avoidDuplicates = new TreeSet<>();
        avoidDuplicates.addAll(this.expressionLeft.getVariables());
        avoidDuplicates.addAll(this.expressionRight.getVariables());
        listVariables.addAll(avoidDuplicates);
        return listVariables;
    }

    /**
     * Get expression left.
     *
     * @return the expression left
     */
    public Expression getExpressionLeft() {
        return this.expressionLeft;
    }

    /**
     * Get expression right.
     *
     * @return the expression right
     */
    public Expression getExpressionRight() {
        return this.expressionRight;
    }
}
