import java.util.List;
import java.util.Map;

public interface Expression {
    /**
     * Evaluate double.
     * Evaluate the expression using the variable values provided in the assignment, and return the result.
     * If the expression contains a variable which is not in the assignment, an exception is thrown.
     *
     * @param assignment the assignment
     * @return the double
     * @throws Exception the exception
     */
    double evaluate(Map<String, Double> assignment) throws Exception;

    /**
     * Evaluate double.
     * A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     *
     * @return the double
     * @throws Exception the exception
     */
    double evaluate() throws Exception;

    /**
     * Gets variables.
     *
     * @return Returns a list of the variables in the expression.
     */
    List<String> getVariables();

    /**
     * toString.
     *
     * @return a nice string representation of the expression.
     */
    String toString();

    /**
     * Assign expression.
     * the func returns a new expression in which all occurrences of the variable var are replaced with the provided
     * expression
     *
     * @param var        the var
     * @param expression the expression
     * @return the expression
     */
    Expression assign(String var, Expression expression);

    /**
     * Differentiate expression.
     * the func. Returns the expression tree resulting from differentiating the current expression
     * relative to variable `var`.
     *
     * @param var the var
     * @return the expression
     */
    Expression differentiate(String var);

    /**
     * Simplify expression.
     *
     * @return a simplified version of the current expression.
     */
    Expression simplify();

}