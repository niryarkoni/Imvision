import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;

public class ExpressionTestPart3 {

    static int gradePart3 = 0;
    static int caseNumber = 0;

    public static int main3() throws Exception
    {

        Map<String, Double> assignment = new TreeMap<String, Double>();
        Expression e = null;
        double value = 0;
        String s = null;

        try
        {
            // ((2*8)-6)^2 =====> 100
            ++caseNumber;
            e = new Mult(new Num(2) , new Num(8));
            e = new Pow( new Minus(new Mult(new Num(2) , new Num(8)) , new Num(6)), new Num(2));
            value = e.evaluate();
            if (value == 100)
            {
                gradePart3++;
            }
            else
            {
                System.out.println("Wrong! case :" + caseNumber );
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



        try
        {
            // ((((2.0 * 8.0) - 6.0)^2.0) * 0.0) = 100 * 0 = 0
            // ans : 0
            ++caseNumber;
            e = new Mult( new Pow( new Minus(new Mult(new Num(2) , new Num(8)) , new Num(6)), new Num(2))
                    , new Num(0));
            value = e.evaluate();

            if (value == 0)
            {
                gradePart3++;
            }
            else
            {
                System.out.println("Wrong! case :" + caseNumber );
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


        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        try
        {
            // ((((2.0 * 8.0) - 6.0)^2.0) / (((2.0 * 8.0) - 6.0)^2.0)) =
            // 100 / 100 = 1
            ++caseNumber;
            e = new Div(new Pow( new Minus(new Mult(new Num(2) , new Num(8)) , new Num(6)), new Num(2)) ,
                    new Pow( new Minus(new Mult(new Num(2) , new Num(8)) , new Num(6)), new Num(2)));
            e = e.simplify();
            if (e.toString().equals("1.0") || e.toString().equals("1"))
            {
                gradePart3++;
            }
            else
            {
                System.out.println("Wrong! case :" + caseNumber );
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


        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        try
        {

            // ((((x * 2.0) + (x * 2.0)) + ((x * 2.0) + (x * 2.0))) * 1.0)
            // x = 2
            // 8x * 1 = 8x
            // ans : 16
            ++caseNumber;
            e = new Mult(new Plus(new Plus(new Mult(new Var("x") , new Num(2)) ,new Mult(new Var("x") , new Num(2)) ) , new Plus(new Mult(new Var("x") , new Num(2)) ,new Mult(new Var("x") , new Num(2)) )) , new Num(1));
            e = e.assign("x", new Num(2));
            value = e.evaluate();

            if (value == 16)
            {
                gradePart3++;
            }
            else
            {
                System.out.println("Wrong! case :" + caseNumber );
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


        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        try
        {

            // ((e^(((2.0 * 8.0) - 6.0)^2.0)) * 1.0)
            // (e^100.0) * 1 = (e^100.0)
            ++caseNumber;
            e = new Mult(new Pow(new Var("e"), new Pow( new Minus(new Mult(new Num(2) , new Num(8)) , new Num(6)), new Num(2))) , new Num(1));
            e = e.simplify();
            s = e.toString().toLowerCase().replaceAll("\\s+","").replaceAll("\\s+","");
            s = s.toLowerCase();

            if (s.equals("(e^100.0)") || s.equals("e^100.0") || s.equals("e^100") || s.equals("(e^100)"))
            {
                gradePart3++;
            }
            else
            {
                System.out.println("Wrong! case :" + caseNumber );
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


        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        try
        {
            // ((((12.0 - 3.0) * 8.0) + 20.0) / 4.0)
            // ans ---> 23
            ++caseNumber;
            e = new Div(new Plus(new Mult(new Minus(new Num(12) , new Num(3)) , new Num(8)) , new Num(20)) , new Num(4));
            s = e.simplify().toString();
            if (s.equals("23.0") || s.equals("23"))
            {
                gradePart3++;
            }
            else
            {
                System.out.println("Wrong! case :" + caseNumber );
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


        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        // (((-1.0 + 1.0) + (-1.0 + 1.0)) + ((-1.0 + 1.0) + (-1.0 + 1.0)))
        // ans = 0
        try
        {
            ++caseNumber;
            Expression a1 = new Plus( new Plus( new Plus(new Num(-1) , new Num(1)) , new Plus(new Num(-1) , new Num(1)))
                    ,new Plus( new Plus(new Num(-1) , new Num(1)) , new Plus(new Num(-1) , new Num(1))) );

            double d = a1.evaluate();
            if (d == 0)
            {
                gradePart3++;
            }
            else
            {
                System.out.println("Wrong! case :" + caseNumber );
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


        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        try
        {
            ++caseNumber;
            // like : X - X = 0
            // ((x^5.0) - (x^5.0))
            // 5x^4 - 5x^4

            e = new Minus(new Pow(new Var("x"), new Num(5)) ,new Pow(new Var("x"), new Num(5)) );
            Expression de = e.differentiate("x");
            Expression simp = de.simplify();  // 0.0

            assignment.clear();
            assignment.put("x", 13.0);
            value = simp.evaluate(assignment);

            if (value == 0)
            {
                gradePart3++;
            }
            else
            {
                System.out.println("Wrong! case :" + caseNumber );
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


        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        try
        {
            ++caseNumber;
            // like : 0 - X = -X
            // (0.0 - (e^(x * 2.0)))
            // should return : -7.389
            // We accepted answers in the range : value >= -7.4 && value <= -7.3

            e = new Minus(new Num(0) , new Pow(new Var("e"), new Mult(new Var("x") , new Num(2))));
            assignment.clear();
            assignment.put("x", 1.0);
            assignment.put("e", 2.71);
            value = e.evaluate(assignment);
            value  = Double.parseDouble(new DecimalFormat("##.###").format(value));

            if (value >= -7.4 && value <= -7.3 )
            {
                gradePart3++;
            }
            else
            {
                System.out.println("Wrong! case :" + caseNumber );
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


        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        try
        {
            ++caseNumber;
            // like : 0 - X = -X
            // ((0.0 - 0.0) - (0.0 - (e^(x * 2.0))))
            // 0 - 0 - (-e^2x)  = e^(2x)
            // after assignment ---> 7.389
            e = new Minus( new Minus(new Num(0) , new Num(0)),
                    new Minus(new Num(0) , new Pow(new Var("e"), new Mult(new Var("x") , new Num(2)))));

            value = e.evaluate(assignment);
            // some cosmetics - uncomment this for some cosmetics to your answer
            // value  = Double.parseDouble(new DecimalFormat("##.###").format(value));

            if (value >= 7.3 && value <= 7.4)
            {
                gradePart3++;
            }
            else
            {
                System.out.println("Wrong! case :" + caseNumber );
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


        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        try
        {
            ++caseNumber;
            // ((Log((2.0 * z), (2.0 * z))) * x)
            // Log(2z,2z) * x = x
            e = new Mult(new Log(new Mult(new Num(2) , new Var("z")) , new Mult(new Num(2) , new Var("z"))) ,
                    new Var("x"));

            if (e.simplify().toString().equals("x"))
            {
                gradePart3++;
            }
            else
            {
                System.out.println("Wrong! case :" + caseNumber );
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


        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        try
        {
            ++caseNumber;
            // (((Log((2.0 * z), (2.0 * z))) * (Cos(0.0))) * (Sin(90.0)))
            // Log(2z,z2) * Cos(0) * sin(90) = 1
            // 1 * 1 * 1 = 1

            e = new Mult(new Mult(new Log(new Mult(new Num(2) , new Var("z")) , new Mult(new Num(2) , new Var("z"))) , new Cos(new Num(0))) , new Sin(new Num(90)) );

            if (e.simplify().toString().equals("1") || e.simplify().toString().equals("1.0"))
            {
                gradePart3++;
            }
            else
            {
                System.out.println("Wrong! case :" + caseNumber );
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


        ////////////////////////////////////////////////////////////////////////////////////////////////////////


        try
        {
            // (((3.0 + 10.0) * x) + ((y * 15.0) * (Sin(0.0))))
            ++caseNumber;
            e = new Plus (new Mult(new Plus(new Num(3) , new Num(10))  , new Var("x"))  ,new Mult( new Mult(new Var("y") , new Num(15)) , new Sin(new Num(0))) );
            // no need of "y" anymore ...

            e = e.simplify();
            e = e.assign("x", new Num(4));

            if (e.evaluate() == 52.0  || e.evaluate() == 52)
            {
                gradePart3++;
            }
            else
            {
                System.out.println("Wrong! case :" + caseNumber );
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


        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        // check if it still can be here ...

        try
        {
            ++caseNumber;
            // ((((20.0 * (x^5.0)) * (3.0 * (e^x))) * (Cos((x^2.0)))) * (x - x))
            // (20*x^5 * 3e^x ) * Cos(x^2) * (x - x)
            // this little beauty equals 0

            e = new Mult(new Mult( new Mult( new Mult(new Num(20) ,new Pow(new Var("x") , new Num(5))) , new Mult(new Num(3) , new Pow(new Var("e"), new Var("x"))) )
                    , new Cos(new Pow(new Var("x") , new Num(2)))) , new Minus(new Var("x") , new Var("x")));


            if (e.simplify().toString().equals("0.0") || e.simplify().toString().equals("0"))
            {
                gradePart3++;
            }
            else
            {
                System.out.println("Wrong! case :" + caseNumber );
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


        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        try
        {
            ++caseNumber;
            // ((((20.0 * (x^5.0)) + (3.0 * (e^x))) * (Cos((x^2.0)))) + (x - x))
            // answer is : 3.0

            e = new Plus(new Mult( new Plus( new Mult(new Num(20) ,new Pow(new Var("x") , new Num(5))) , new Mult(new Num(3) , new Pow(new Var("e"), new Var("x"))) )
                    , new Cos(new Pow(new Var("x") , new Num(2)))) , new Minus(new Var("x") , new Var("x")));
            assignment.clear();
            assignment.put("x", 0.0);
            assignment.put("e", 2.71);
            value = e.evaluate(assignment);

            if (value == 3.0 || value == 3)
            {
                gradePart3++;
            }
            else
            {
                System.out.println("Wrong! case :" + caseNumber );
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


        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        try
        {
            ++caseNumber;
            // ((((e^x) * (e^x)) * ((e^x) * (e^x))) * 0.0)
            // ans : 0

            e = new Mult(new Mult(new Mult (new Pow(new Var("e"), new Var("x")) , new Pow(new Var("e"), new Var("x"))) , new Mult (new Pow(new Var("e"), new Var("x")) , new Pow(new Var("e"), new Var("x")))) , new Num(0));
            e = e.assign("x", new Num(4));
            e = e.assign("e", new Num(2.71));
            value = e.evaluate();
            if (value == 0)
            {
                gradePart3++;
            }
            else
            {
                System.out.println("Wrong! case :" + caseNumber );
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


        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        // new one : x = 0 , e = 2.71
        // your output should be : 1
        // [ (e^x * e^2x) / (e^3x) ]  * [(e^4x * e^3x) / e^7x] * [e^15x / (e^7x * e^8x)]

        try
        {
            // ((((e^x) * ((e^x)^2.0)) / ((e^x)^3.0)) * ((((e^x)^4.0) * ((e^x)^3.0)) / ((e^x)^7.0)))
            // ans : 1
            ++caseNumber;
            e = new Mult(new Div(new Mult(new Pow(new Var("e"), new Var("x")) ,new Pow(new Pow(new Var("e"), new Var("x")) , new Num(2))) , new Pow(new Pow(new Var("e"), new Var("x")) , new Num(3)))
                    , new Div( new Mult(new Pow(new Pow(new Var("e"), new Var("x")) , new Num(4)) , new Pow(new Pow(new Var("e"), new Var("x")) , new Num(3)) ) ,e = new Pow(new Pow(new Var("e"), new Var("x")) , new Num(7)) ));

            e = e.assign("e", new Num(2.71));
            e = e.assign("x", new Num(0));
            value = e.evaluate();

            if (value == 1)
            {
                gradePart3++;
            }
            else
            {
                System.out.println("Wrong! case :" + caseNumber );
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


        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        // (((((e^x) * ((e^x)^2.0)) / ((e^x)^3.0)) / ((((e^x)^4.0) * ((e^x)^3.0)) / ((e^x)^7.0))) * (Sin(0.0)))
        // x = 0
        // your output should be : 0

        try
        {
            ++caseNumber;
            e = new Mult(new Div( new Div(new Mult(new Pow(new Var("e"), new Var("x")) ,new Pow(new Pow(new Var("e"), new Var("x")) , new Num(2))) , new Pow(new Pow(new Var("e"), new Var("x")) , new Num(3)))
                    , new Div( new Mult(new Pow(new Pow(new Var("e"), new Var("x")) , new Num(4)) , new Pow(new Pow(new Var("e"), new Var("x")) , new Num(3)) ) ,e = new Pow(new Pow(new Var("e"), new Var("x")) , new Num(7)) )) , new Sin(new Num(0)));

            e = e.assign("e", new Num(2.71));
            e = e.assign("x", new Num(0));
            value = e.evaluate();

            if (value == 0)
            {
                gradePart3++;
            }
            else
            {
                System.out.println("Wrong! case :" + caseNumber );
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


        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        try
        {
            // (Sin(-(-(-(-(-(0.0))))))) = 0
            // -0 is also ok
            ++caseNumber;
            e = new Sin(new Neg(new Neg(new Neg(new Neg(new Neg(new Num(0)))))));
            value = e.evaluate();

            if (value == 0)
            {
                gradePart3++;
            }
            else
            {
                System.out.println("Wrong! case :" + caseNumber );
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


        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        try
        {

            // Let's see if the exception mechanism you built
            // is working OK , if you have a missing VAR , then
            // I want to catch an exception
            ++caseNumber;
            // (x + y)

            e = new Plus(new Var("x") , new Var("y"));
            e = e.assign("x", new Num(2));
            // e = e.assign("y", new Num(2));
            value = e.evaluate();
        }

        catch (Exception exp)
        {
            gradePart3++;
        }


        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        try
        {
            ++caseNumber;
            // (((x * 2.0) - ((x * 2.0) + (y * 3.0))) * ((-(9.0) / -(9.0)) + ((-(9.0) / -(9.0)) * -(-1.0))))
            // (((2.0 * 2.0) - ((2.0 * 2.0) + (3.0 * 3.0))) * ((-(9.0) / -(9.0)) + ((-(9.0) / -(9.0)) * -(-1.0))))
            e = new Mult(new Minus(new Mult("x" , 2.0) , new Plus(new Mult("x" , 2.0) , new Mult("y" , 3.0))) ,new Plus(new Div(new Neg(9.0) , new Neg(9.0)) , new Mult(new Div(new Neg(9.0) , new Neg(9.0)) , new Neg(-1.0))) );
            e = e.assign("x", new Num(2));
            e = e.assign("y", new Num(3));
            value = e.evaluate();
            if (value == -18)
            {
                gradePart3++;
            }
            else
            {
                System.out.println("Wrong! case :" + caseNumber );
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


        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        try
        {
            ++caseNumber;
            // ((1.0 + -(-9.0)) * -(-(-(-(-(-(-(-(-(-(-(-(-1.0))))))))))))) = -10.0
            e = new Mult(new Plus("x" , new Neg(-9.0)) ,new Neg(new Neg(new Neg(new Neg(new Neg(new Neg(new Neg(new Neg(new Neg(new Neg(new Neg(new Neg(-1.0)))))))))))) );
            e = e.assign("x", new Num(1));
            value = e.evaluate();


            if (value == -10)
            {
                gradePart3++;
            }
            else
            {
                System.out.println("Wrong! case :" + caseNumber );
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

        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Total cases part 3:" + caseNumber + "\n");
        return gradePart3;

    }
}
