
import java.util.Map;
import java.util.TreeMap;

public class ExpressionsTest {
    /**
     * Main.
     *
     * @param args the args
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {
        Expression expression = new Plus(
                new Mult(2, "x"),
                new Plus(
                        new Sin(new Mult(4, "y")),
                        new Pow("e", "x")
                ));
        Map<String, Double> assignment = new TreeMap<>();

        assignment.put("x", 2.0);
        assignment.put("y", 0.25);
        assignment.put("e", 2.71);

        System.out.println(expression);
        System.out.println(expression.evaluate(assignment));
        System.out.println(expression.differentiate("x"));
        System.out.println(expression.differentiate("x").evaluate(assignment));
        System.out.println(expression.differentiate("x").simplify());
    }
}
