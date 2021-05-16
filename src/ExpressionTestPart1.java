
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ExpressionTestPart1 {

    static int gradePart1 = 0;
    static int caseNumber = 0;


    // public static void main(String[] args) throws Exception {

    public static int main1() throws Exception {

        // part 1

        // Expression
        // getVariables
        // assign
        // evaluate
        // Var , Sin , Plus , Mul , Pow

        Expression e14 = null;
        Expression e22 = null;
        Expression p43 = null;
        double value = 0;
        String valString = null;
        String s = null;
        Expression e23 = null;
        Map<String, Double> assignment = new TreeMap<String, Double>();
        List<String> vars = null;

        try {

            ++caseNumber;

            // (x^1 + y^2)^2 + (w^3 + z^4)^2
            p43 = new Plus(new Pow(new Plus(new Pow(new Var("p"), 1), new Pow(
                    new Var("o"), 2)), new Num(2)), new Pow(new Plus(new Pow(
                    new Var("g"), 3), new Pow(new Var("w"), 4)), new Num(2)));

            assignment.put("p", 4.5);
            assignment.put("o", 5.5);
            assignment.put("g", 1.0);
            assignment.put("w", 2.0);
            value = p43.evaluate(assignment);

            if (value == 1496.5625)
            // if
            // (toLowerCase(p43).contains(("(x^1.0+y^2.0)^2.0+(w^3.0+z^4.0)^2.0")))
            {
                gradePart1++;
            } else {
                System.out.println("Test 1 failed");
            }
        }

        catch (Exception exp) {
            System.out.println("Test " + (caseNumber) + " failed");
        }

        catch (StackOverflowError t) {
            System.out.println("Caught StackOverflowError");
            System.out.println("Test " + (caseNumber) + " failed");
        }

        // //////////////////////////////////////////////////////////////////////////////////////////////////////

        try {

            ++caseNumber;

            // ans is : (((x + y) + (z + w))^4.0)
            e23 = new Pow(new Plus(new Plus(new Var("x"), new Var("y")),
                    new Plus(new Var("z"), new Var("w"))), new Num(4));
            s = e23.toString().toLowerCase().replaceAll("\\s+", "");

            // (((x+y)+(z+w))^4.0)
            if (s.equals("(((x+y)+(z+w))^4.0)")) {
                gradePart1++;
            } else {
                System.out.println("Test 2 failed");
            }
        }

        catch (Exception exp) {
            System.out.println("Test " + (caseNumber) + " failed");
        }

        catch (StackOverflowError t) {
            System.out.println("Caught StackOverflowError");
            System.out.println("Test " + (caseNumber) + " failed");
        }

        // /////////////////////////////////////////////////////////////////////////////////////////////////////

        try {

            ++caseNumber;


            // The result is: 234256.0
            assignment.put("x", 2.0);
            assignment.put("y", 4.0);
            assignment.put("z", 6.0);
            assignment.put("w", 10.0);
            value = e23.evaluate(assignment);

            if (value == 234256.0) {
                gradePart1++;
            } else {
                System.out.println("Test 3 failed");
            }
        }

        catch (Exception exp) {
            System.out.println("Test " + (caseNumber) + " failed");
        }

        catch (StackOverflowError t) {
            System.out.println("Caught StackOverflowError");
            System.out.println("Test " + (caseNumber) + " failed");
        }

        // /////////////////////////////////////////////////////////////////////////////////////////////////////

        try {

            ++caseNumber;


            // get vars of e23
            // ans is (the order is not important) :
            // x
            // y
            // z
            // w
            vars = e23.getVariables();
            Collections.sort(vars);

            List<String> correct = new ArrayList<String>();
            correct.add("x");
            correct.add("y");
            correct.add("z");
            correct.add("w");

            boolean ans = correct.retainAll(vars);
            if (!ans) {
                gradePart1++;
            } else {
                System.out.println("Test 4 failed");
            }
        }

        catch (Exception exp) {
            System.out.println("Test " + (caseNumber) + " failed");
        }

        catch (StackOverflowError t) {
            System.out.println("Caught StackOverflowError");
            System.out.println("Test " + (caseNumber) + " failed");
        }

        // /////////////////////////////////////////////////////////////////////////////////////////////////////

        try {

            ++caseNumber;


            // (x + y)^0 = 1 , always !
            // ans is : 1.0 or 1
            Expression e2 = new Pow(new Plus(new Var("x"), new Var("y")),
                    new Num(0));
            value = e2.evaluate(assignment);
            if (value == 1) {
                gradePart1++;
            } else {
                System.out.println("Test 5 failed");
            }
        }

        catch (Exception exp) {
            System.out.println("Test " + (caseNumber) + " failed");
        }

        catch (StackOverflowError t) {
            System.out.println("Caught StackOverflowError");
            System.out.println("Test " + (caseNumber) + " failed");
        }

        // /////////////////////////////////////////////////////////////////////////////////////////////////////

        try {

            ++caseNumber;

            // (x + y)^(-1)
            // Accepted answers :
            // 0.167
            // 0.166

            // ans is : (value >= 0.16 && value <= 0.17)
            // here we accept 0.16 + epsilon

            Expression e4 = new Pow(new Plus(new Var("x"), new Var("y")),
                    new Num(-1));
            value = e4.evaluate(assignment);
            value = Double.parseDouble(new DecimalFormat("##.###")
                    .format(value));

            if (value >= 0.16 && value <= 0.17) {
                gradePart1++;
            } else {
                System.out.println("Test 6 failed");
            }
        }

        catch (Exception exp) {
            System.out.println("Test " + (caseNumber) + " failed");
        }

        catch (StackOverflowError t) {
            System.out.println("Caught StackOverflowError");
            System.out.println("Test " + (caseNumber) + " failed");
        }

        // /////////////////////////////////////////////////////////////////////////////////////////////////////

        try {

            ++caseNumber;


            // -(x)
            // ans is : -2 (the assignment is above)

            Expression e5 = new Neg(new Var("x"));
            valString = e5.toString().toLowerCase().replaceAll("\\s+", "");
            value = e5.evaluate(assignment);

            if (value == -2) {
                gradePart1++;
            } else {
                System.out.println("Test 7 failed");
            }

        }

        catch (Exception exp) {
            System.out.println("Test " + (caseNumber) + " failed");
        }

        catch (StackOverflowError t) {
            System.out.println("Caught StackOverflowError");
            System.out.println("Test " + (caseNumber) + " failed");
        }

        // /////////////////////////////////////////////////////////////////////////////////////////////////////

        // ans is : x , where x = 2
        // final ans is : 2
        try {

            ++caseNumber;


            // -(-x) = x
            Expression e6 = new Neg(new Neg(new Var("x")));
            value = e6.evaluate(assignment);
            if (value == 2) {
                gradePart1++;
            } else {
                System.out.println("Test 8 failed");
            }
        }

        catch (Exception exp) {
            System.out.println("Test " + (caseNumber) + " failed");
        }

        catch (StackOverflowError t) {
            System.out.println("Caught StackOverflowError");
            System.out.println("Test " + (caseNumber) + " failed");
        }

        // /////////////////////////////////////////////////////////////////////////////////////////////////////

        try {

            ++caseNumber;

            // -(-(-(-y))) = y
            // y equals to 4
            // final ans : 4.0
            Expression e7 = new Neg(new Neg(new Neg(new Neg(new Var("y")))));
            value = e7.evaluate(assignment);
            if (value == 4) {
                gradePart1++;
            } else {
                System.out.println("Test 9 failed");
            }
        }

        catch (Exception exp) {
            System.out.println("Test " + (caseNumber) + " failed");
        }

        catch (StackOverflowError t) {
            System.out.println("Caught StackOverflowError");
            System.out.println("Test " + (caseNumber) + " failed");
        }

        // /////////////////////////////////////////////////////////////////////////////////////////////////////

        try {

            ++caseNumber;


            // [ (-x) - (-y) ] ^ 2 = [ -x + y ] ^ 2 = [ -2 + 4 ] ^ 2 = 2^2 = 4
            // ans is : 4.0
            Expression e8 = new Pow(new Minus(new Neg(new Var("x")), new Neg(
                    new Var("y"))), new Num(2));
            valString = e8.toString().toLowerCase().replaceAll("\\s+", "");

            assignment.clear();
            assignment.put("x", -2.0);
            assignment.put("y", -4.0);
            value = e8.evaluate(assignment);
            if (value == 4) {
                gradePart1++;
            } else {
                System.out.println("Test 10 failed");
            }
        }

        catch (Exception exp) {
            System.out.println("Test " + (caseNumber) + " failed");
        }

        catch (StackOverflowError t) {
            System.out.println("Caught StackOverflowError");
            System.out.println("Test " + (caseNumber) + " failed");
        }

        // /////////////////////////////////////////////////////////////////////////////////////////////////////

        try {

            ++caseNumber;

            // (-x) * (-(-y)) = (-)*x*y = -xy
            // -2 * 4 = - 8
            // ans is : -8
            Expression e9 = new Mult(new Neg(new Var("x")), new Neg(new Neg(
                    new Var("y"))));
            assignment.clear();
            assignment.put("x", (double) -2);
            assignment.put("y", (double) -4);
            value = e9.evaluate(assignment);
            if (value == -8) {
                gradePart1++;
            } else {
                System.out.println("Test 11 failed");
            }
        }

        catch (Exception exp) {
            System.out.println("Test 11 failed");
        }

        catch (StackOverflowError t) {
            System.out.println("Caught StackOverflowError");
        }

        // /////////////////////////////////////////////////////////////////////////////////////////////////////

        try {

            ++caseNumber;


            // log of 1 with base 2
            // ans is : 0
            Expression e10 = new Log(new Num(2), new Num(1));
            value = e10.evaluate(assignment);
            if (value == 0) {
                gradePart1++;
            } else {
                System.out.println("Test 12 failed");
            }
        }

        catch (Exception exp) {
            System.out.println("Test " + (caseNumber) + " failed");
        }

        catch (StackOverflowError t) {
            System.out.println("Caught StackOverflowError");
            System.out.println("Test " + (caseNumber) + " failed");
        }

        // /////////////////////////////////////////////////////////////////////////////////////////////////////

        try {

            ++caseNumber;


            // (cos(0) - cos(0)) - (cos0 + cos0)
            // 0 - (1 + 1) = 0 - 2 = -2
            // ans is : -2
            Expression e11 = new Cos(new Num(0));
            e11 = new Minus(
                    new Minus(new Cos(new Num(0)), new Cos(new Num(0))),
                    new Plus(new Cos(new Num(0)), new Cos(new Num(0))));
            value = e11.evaluate();
            if (value == -2) {
                gradePart1++;
            } else {
                System.out.println("Test 13 failed");
            }
        }

        catch (Exception exp) {
            System.out.println("Test " + (caseNumber) + " failed");
        }

        catch (StackOverflowError t) {
            System.out.println("Caught StackOverflowError");
            System.out.println("Test " + (caseNumber) + " failed");
        }

        // /////////////////////////////////////////////////////////////////////////////////////////////////////

        try {

            ++caseNumber;


            // sin45 + cos 45
            // Accepted answer :
            // 1.414
            // ans is : 1.4 + epsilon
            Expression e12 = new Plus(new Cos(new Num(45)),
                    new Sin(new Num(45)));
            e12.toString().toLowerCase().replaceAll("\\s+", "");
            value = e12.evaluate();
            value = Double.parseDouble(new DecimalFormat("##.###")
                    .format(value));

            if (value >= 1.4 && value <= 1.5) {
                gradePart1++;
            } else {
                System.out.println("Test 14 failed");
            }
        }

        catch (Exception exp) {
            System.out.println("Test " + (caseNumber) + " failed");
        }

        catch (StackOverflowError t) {
            System.out.println("Caught StackOverflowError");
            System.out.println("Test " + (caseNumber) + " failed");
        }

        // /////////////////////////////////////////////////////////////////////////////////////////////////////

        try {

            ++caseNumber;


            // sin(45)^2 + cos(45)^2 = 1 , trigonometric identity
            // ans is : 1.0
            Expression e13 = new Plus(
                    new Pow(new Cos(new Num(45)), new Num(2)), new Pow(new Sin(
                    new Num(45)), new Num(2)));
            value = e13.evaluate();

            if (value == 1) {
                gradePart1++;
            } else {
                System.out.println("Test 15 failed");
            }
        }

        catch (Exception exp) {
            System.out.println("Test " + (caseNumber) + " failed");
        }

        catch (StackOverflowError t) {
            System.out.println("Caught StackOverflowError");
            System.out.println("Test " + (caseNumber) + " failed");
        }

        // /////////////////////////////////////////////////////////////////////////////////////////////////////

        try {

            ++caseNumber;


            // -----(-2) plus -----(1) = 1
            // ans is : 1
            e14 = new Plus(new Neg(new Neg(new Neg(
                    new Neg(new Neg(new Num(-2)))))), new Neg(new Neg(new Neg(
                    new Neg(new Neg(new Num(1)))))));
            e14.toString().toLowerCase().replaceAll("\\s+", "");
            value = e14.evaluate();

            if (value == 1) {
                gradePart1++;
            } else {
                System.out.println("Test 16 failed");
            }

        }

        catch (Exception exp) {
            System.out.println("Test " + (caseNumber) + " failed");
        }

        catch (StackOverflowError t) {
            System.out.println("Caught StackOverflowError");
            System.out.println("Test " + (caseNumber) + " failed");
        }

        // /////////////////////////////////////////////////////////////////////////////////////////////////////

        try {

            ++caseNumber;


            // get the var of e14 ---> should return none
            // ans is "null" or "0"
            vars = e14.getVariables();

            if (vars == null || vars.size() == 0) {
                gradePart1++;
            } else {
                System.out.println("Test 1 failed");
            }
        }

        catch (Exception exp) {
            System.out.println("Test " + (caseNumber) + " failed");
        }

        catch (StackOverflowError t) {
            System.out.println("Caught StackOverflowError");
            System.out.println("Test " + (caseNumber) + " failed");
        }

        // /////////////////////////////////////////////////////////////////////////////////////////////////////

        // ((((a^-1 + c^2 + b^-3 + e^4 +d^-5)^0)^1)^2)
        try {

            ++caseNumber;


            p43 = new Pow(new Pow(
                    new Pow(new Neg(new Neg(

                            new Plus(new Plus(new Plus(new Pow(new Var("a"), -1),
                                    new Pow(new Var("c"), 2)), new Plus(new Pow(
                                    new Var("c"), -3), new Pow(new Var("e"), 4))),
                                    new Pow(new Var("d"), -5)))), 0), 1), 2);

            assignment.clear();
            assignment.put("a", 1.0);
            assignment.put("b", 1.0);
            assignment.put("c", 2.0);
            assignment.put("d", 2.0);
            assignment.put("e", 3.0);

            double output = p43.evaluate(assignment) - 1;



            if (output == 0) {
                gradePart1++;
            }
        }

        catch (Exception exp)
        {
            System.out.println("Test " + (caseNumber) + " failed");
        }

        catch (StackOverflowError t) {
            System.out.println("Caught StackOverflowError");
            System.out.println("Test " + (caseNumber) + " failed");
        }

        // ------------------------------------------------------------------------------------------------------------------------------------------------

        // -----(1) + -----(-1) = (-1) + 1 = 0
        try {
            ++caseNumber;

            e14 = new Plus
                    (new Neg(new Neg(new Neg(new Neg(new Neg(new Num(1)))))),
                            new Neg(new Neg(new Neg(new Neg(new Neg(new Num(-1)))))));

            if (e14.evaluate() == 0) {
                gradePart1++;
            }
        } catch (Exception exp) {
            System.out.println("Test " + (caseNumber) + " failed");
        }

        catch (StackOverflowError t) {
            System.out.println("Caught StackOverflowError");
            System.out.println("Test " + (caseNumber) + " failed");
        }


        // ------------------------------------------------------------------------------------------------------------------------------------------------

        try
        {
            ++caseNumber;
            p43 = null;
            vars = p43.getVariables();
        }


        catch (Exception exp)
        {
            gradePart1++;
        }

        catch (StackOverflowError t)
        {
            gradePart1++;
        }

        // ------------------------------------------------------------------------------------------------------------------------------------------------


        try
        {
            ++caseNumber;
            e14 = new Plus
                    (new Neg(new Neg(new Neg(new Neg(new Neg(new Num(-1)))))),
                            new Neg(new Neg(new Neg(new Neg(new Neg(new Num(-1)))))));

            p43 = new Num(99);
            if (((p43.getVariables().size()) * e14.evaluate()) == 0)
            {
                gradePart1++;
            }

        }

        catch (Exception exp) {
            System.out.println("Test " + (caseNumber) + " failed");
        }

        catch (StackOverflowError t) {
            System.out.println("Caught StackOverflowError");
            System.out.println("Test " + (caseNumber) + " failed");
        }




        System.out.println("Total cases part 1:" + caseNumber + "\n");
        return gradePart1;

    }

}