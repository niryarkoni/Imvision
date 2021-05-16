
import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;

public class ExpressionTestPart2 {

    static int gradePart2 = 0;
    static int caseNumber = 0;

    // public static void main(String[] args) throws Exception {

    public static int main2() throws Exception {

        Map<String, Double> assignment = new TreeMap<String, Double>();

        Expression e = null;
        Expression de = null;
        Expression simp = null;
        String simpStr = null;
        double value = 0;
        double vv = 0;

        // given : (-1/x) / (-1/x) / (-1/x)
        try
        {
            ++caseNumber;
            e = new Plus(new Neg(new Neg(new Neg(new Neg(new Neg(new Neg( new Neg( new Neg(new Num(9))))))))) ,
                    new Neg(new Neg(new Neg(new Neg(new Neg(new Neg(new Neg( new Neg( new Neg(new Num(-11)))))))))));

            value = e.evaluate();
            if (value == 20)
            {
                gradePart2++;
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



        // given : (-1/x) / (-1/x) / (-1/x)
        try
        {

            ++caseNumber;
            e = new Mult(new Var("x") ,new Div(new Div(new Div(new Neg(new Num(1)) , new Var("x")) ,new Div(new Neg(new Num(1)) , new Var("x")) ) ,
                    new Div(new Neg(new Num(1)) , new Var("x"))));
            de = e.simplify();
            //de = e.differentiate("x");
            de = de.assign("x", new Num(4));	// -16

            value = de.evaluate();
            if (value == -16)
            {
                gradePart2++;
            }
            else
            {
                System.out.println("Wrong! ");
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

        // given : -(1/x)
        try
        {
            ++caseNumber;
            e = new Div(new Neg(new Num(1)) , new Var("x"));	// -1/x
            de = e.differentiate("x");			// 1/x^2
            de = new Div(new Var("x") ,de); 	// x / (1/x^2) = x^3
            de = de.simplify();
            de = de.assign("x", new Num(4));	// 64

            value = de.evaluate();
            if (value == 64)
            {
                gradePart2++;
            }
            else
            {
                System.out.println("Wrong! ");
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

        // given : -(1/x)
        try
        {
            ++caseNumber;
            e = new Div(new Neg(new Num(1)) , new Var("x"));	// -1/x
            de = e.differentiate("x");			// 1/x^2
            de = new Div(new Num(1) ,de); 	// 1 / (1/x^2) = x^2
            de = de.simplify();
            de = de.assign("x", new Num(4));	// 16

            value = de.evaluate();
            if (value == 16)
            {
                gradePart2++;
            }
            else
            {
                System.out.println("Wrong! ");
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



        //	System.out.println("-----------test 18----------------------------------");
        // given : x^10
        // after differentiate : 10x^9 , assigning x=10 , produces :
        // ans : 2621440

        try
        {
            ++caseNumber;
            e = new Pow(new Var("x"), new Num(10));
            de = e.differentiate("x");
            de = de.assign("x", new Num(4));
            de = de.assign("e", new Num(2.71));
            value = de.evaluate();
            if (value == 2621440)
            {
                gradePart2++;
            }
            else
            {
                System.out.println("Wrong! 18");
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
        //	System.out.println("-----------test 19----------------------------------");

        try
        {
            // exp = 1 , differentiate by x , return 0
            // ans is : 0
            ++caseNumber;
            e = new Num(1);
            de = e.differentiate("x");
            value = de.evaluate();
            if (value == 0)
            {
                gradePart2++;
            }
            else
            {
                System.out.println("Wrong! 19");
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

        //	System.out.println("-----------test 20----------------------------------");
        // -----(-2) , with differentiate , returns 0
        // ans is : 0

        try
        {
            ++caseNumber;
            e = new Neg(new Neg(new Neg(new Neg(new Neg(new Num(-2))))));
            de = e.differentiate("x");
            value = de.evaluate();

            if (value == 0)
            {
                gradePart2++;
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
        //	System.out.println("-----------test 21----------------------------------");

        try
        {
            ++caseNumber;
            // x^4 , differentiate by y
            // ans : 0
            e = new Pow(new Var("x"), new Num(4));
            de = e.differentiate("y");
            simp = de.simplify();
            simpStr = simp.toString().toLowerCase().replaceAll("\\s+","");

            if (simpStr.equals("0.0") || simpStr.equals("0"))
            {
                gradePart2++;
            }
            else
            {
                System.out.println("Wrong! 21");
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
        //	System.out.println("-----------test 22----------------------------------");
        // x*y , differentiate by y , result is : x
        // ans : x
        // final : 2

        try
        {
            ++caseNumber;
            assignment.put("x",  2.0);
            assignment.put("y",  4.0);

            e = new Mult(new Var("x") , new Var("y"));
            de = e.differentiate("y");
            value = de.evaluate(assignment);

            if (value == 2)
            {
                gradePart2++;
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
        //		System.out.println("-----------test 23----------------------------------");
        // e = 1/x
        // differentiate by x
        // e' = - (1 / x^2)  , assign x = 2
        // produces : - (1 / 4) = -0.25
        // should return 0
        // ans : -1/4 = -0.25

        try
        {

            ++caseNumber;
            e = new Div(new Num(1) , new Var("x"));
            e = e.differentiate("x");

            assignment.clear();
            assignment.put("x", 2.0);
            vv = e.evaluate(assignment);

            if (vv == -0.25)
            {
                gradePart2++;
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

        //	System.out.println("-----------test 24----------------------------------");
        // sin(x) / sin(x) , no differentiate
        // here we won't differentiate by x
        // ans : 1

        try
        {

            ++caseNumber;
            e = new Div( new Sin(new Var("x"))
                    ,new Sin(new Var("x")) );
            value = e.evaluate(assignment);
            if (value == 1)
            {
                gradePart2++;
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


        //	System.out.println("-----------test 25----------------------------------");
        // x/x , with differentiate : x/x = 1 ===> (1)' = 0
        // ans is : 0

        try
        {

            ++caseNumber;
            e = new Div(new Var("x") , new Var("x"));
            e = e.differentiate("x");
            value = e.evaluate(assignment);
            if (value == 0)
            {
                gradePart2++;
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
        // x + x
        // ans : 1 +1 = 2

        try
        {

            ++caseNumber;
            e = new Plus(new Var("x") , new Var("x"));
            e =  e.differentiate("x");
            value = e.evaluate(assignment);

            if (value == 2)
            {
                gradePart2++;
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
            // f(x) = x - x
            // f'(x) = 1 - 1 = 0
            // ans : 0
            e = new Minus(new Var("x") , new Var("x"));
            e = e.differentiate("x");
            value = e.evaluate(assignment);

            if (value == 0)
            {
                gradePart2++;
            }
            else
            {
                System.out.println("Wrong!");
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
            // differentiate Sin(x) ===> return Cos(x)
            // cos(0) = 1
            // ans : 1

            e = new Sin(new Var("x"));  // sin(x)
            e = e.differentiate("x");  // cos(x)

            assignment.clear();
            assignment.put("x", (double) 0);  // cos(0) = 1
            value = e.evaluate(assignment);

            if (value == 1)
            {
                gradePart2++;
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

            e = new Cos(new Var("x"));		// cos(x)
            e = e.differentiate("x");		// -sin(x)
            assignment.clear();
            assignment.put("x",  90.0);		// -sin(90) = -1
            value = e.evaluate(assignment);

            if (value == -1)
            {
                gradePart2++;
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
            // differentiate [Cos(x)]^2
            // -2 * cos(x) * sin(x)
            // after assignment ---> -0.866025403784
            // we will accept answers that are between : value >= -0.9 && value <= -0.8

            e = new Pow(new Cos(new Var("x")) , new Num(2));		// [cos(x)]^2
            e = e.differentiate("x");		// 2 * cos(x) * (-sin(x)) = -2 * sin(x) * cos(x)
            assignment.clear();
            assignment.put("x",  60.0);		// -2 * sin(60) * cos(60) =  -0.866025403784
            assignment.put("e", 2.71);
            value = e.evaluate(assignment);

            if (value >= -0.9 && value <= -0.8 )
            {
                gradePart2++;
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
            // differentiate [Cos(x)]^3
            // after : 3 * [cos(x)]^2 * (-sin(x))
            // assigning x = 60 =====> 3 * cos(60)^2 * (-sin(60))
            // answer : -0.649519052838
            // however : we will accept answers that are in the range of : value >= -0.7 && value <= -0.6

            e = new Pow(new Cos(new Var("x")) , new Num(3));  // [Cos(x)]^3
            e = e.differentiate("x");						  // 3 * [cos(x)]^2 * (-sin(x))
            assignment.clear();
            assignment.put("x", 60.0);
            assignment.put("e", 2.71);
            value = e.evaluate(assignment);					  // 3 * cos(60)^2 * (-sin(60)) = -0.649519052838

            if (value >= -0.7 && value <= -0.6 )
            {
                gradePart2++;
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

        // differentiate : [Sin(x^2)] , by x
        // cos(x^2) * 2x

        try
        {
            ++caseNumber;
            e = new Sin(new Pow (new Var("x") , new Num(2)));		// sin(x^2)
            e = e.differentiate("x");								// cos(x^2) * 2x
            assignment.clear();
            assignment.put("x", 90.0);								// cos(90^2) * 2 * 90 = -180
            assignment.put("e", 2.71);
            value = e.evaluate(assignment);

            if (value == -180 )
            {
                gradePart2++;
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
            // differentiate : x^2 * x^2 , assign 30
            // so : x^4 ====> differentiate =====> 4 * x^3 ====> 4 * (13^3)
            Expression ee3 = new Mult(new Pow(new Var("x") , new Num(2)) , new Pow(new Var("x") , new Num(2)));   // x^2 * x^2
            ee3 = ee3.differentiate("x"); // 4 * x^3
            assignment.clear();
            assignment.put("x", 13.0);
            assignment.put("e", 2.71);
            value = ee3.evaluate(assignment);   // 4 * 13^3

            if (value == 8788.0 )
            {
                gradePart2++;
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
            // 4x * 20x = 80 * x^2
            // after differentiate --> 160x
            // with x = 1 , result is : 160

            e = new Mult(new Mult(new Var("x") , new Num(4)) ,
                    new Mult(new Var("x") , new Num(20)));

            e = e.differentiate("x").simplify();

            assignment.clear();
            assignment.put("x", 1.0);
            value = e.evaluate(assignment);

            if (value == 160)
            {
                gradePart2++;
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

            // 100x + 20x
            // = 120x
            // differentiate by "y"
            // produces 0
            e = new Plus(new Mult(new Var("x") , new Num(100)) ,
                    new Mult(new Var("x") , new Num(20))
            );

            e = e.differentiate("y").simplify();
            value = e.evaluate();
            if (value == 0 )
            {
                gradePart2++;
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

        // [-cos(x)] + [-sin(x)] + cos(x) + sin(x) = 0

        try
        {
            ++caseNumber;

            e = new Plus( new Plus(new Neg(new Cos(new Var("x"))) , new Neg(new Sin(new Var("x"))) ) ,
                    new Plus(new Cos(new Var("x")) , new Sin(new Var("x")))
            );

            assignment.clear();
            assignment.put("x", 0.0);
            value = e.evaluate(assignment);

            if (value == 0 )
            {
                gradePart2++;
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

        // -cos(x) * (-sin(x)) = cos(x) * sin(x)
        // From infi : (-sin(x)) * sin(x) + cos(x) * cos(x) = -sin(x)^2 + cos(x)^2 = cos(x)^2 - sin(x)^2
        // Note that : cos(x)^2 = [cos(x)]^2
        // ans is : cos(x)^2 - sin(x)^2
        // assign x = 0 =======> cos(0)^2 - sin(0)^2 = 1 - 0 = 1
        // ans is : 1

        try
        {

            ++caseNumber;
            e = new Mult(new Neg(new Cos(new Var("x"))) , new Neg(new Sin(new Var("x"))) );
            e = e.differentiate("x");
            assignment.clear();
            assignment.put("x", 0.0);
            value = e.evaluate(assignment);

            if (value == 1 )
            {
                gradePart2++;
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
            // cos(-x) + sin(-x)
            // result : -sin(x) -cos(x)
            // should return -1

            e = new Plus(new Cos(new Neg(new Var("x"))) , new Sin(new Neg(new Var("x"))));  // cos(-x) + sin(-x)
            e = e.differentiate("x");														// -1 * (-1) * sin(-x) + cos(-x) * (-1) = sin(-x) - cos(-x)
            // note that : sin(-x) = -sin(x)
            // also : cos(-x) = cos(x)
            // hence : sin(-x) - cos(-x)  = -sin(x) - cos(x)

            assignment.clear();
            assignment.put("x", 0.0);		// sin(-0) - cos(-0) = 0 - 1 = -1

            value = e.evaluate(assignment);

            if (value == -1 )
            {
                gradePart2++;
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
            // -e^(-x) , Euler's e number :) Some respect baby !
            // after differentiate : (-) * (-1) * e^(-x) = e^(-x)
            // final ans : we accepted answers in the range : value >= 2.7 && value <= 2.8
            ++caseNumber;

            e = new Mult(new Num(-1) , new Pow(new Var("e"), new Mult(new Var("x") , new Num(-1))));  // -e^(-x)
            e = e.differentiate("x");																  // (-) * (-1) * e^(-x) = e^(-x)
            e = e.assign("e", new Num(2.71));
            e = e.assign("x", new Num(-1));  // e^(--1) = e^1 2.718...
            value = e.evaluate();


            if (value >= 2.7 && value <= 2.8)
            {
                gradePart2++;
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
            // e^2x
            // should return : 2 *e^2x
            // with value "1" , returns : 14.778112197861299
            // 14.778
            // We'll accept answers that are in the range : value >= 14 && value <= 15
            ++caseNumber;
            e = new Pow(new Var("e"), new Mult(new Var("x") , new Num(2)));		// e^(2x)
            e = e.differentiate("x").simplify();								// 2 * e^(2x)

            assignment.clear();
            assignment.put("x", 1.0);		// 2 * e^2 = 14.7781121978613005
            assignment.put("e", 2.71);
            value = e.evaluate(assignment);

            if (value >= 14 && value <= 15)
            {
                gradePart2++;
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

            // e^x / e^x = 1
            // Ans : 1
            e = new Div(new Pow(new Var("e"), new Var("x")) , new Pow(new Var("e"), new Var("x")) );
            simpStr = e.simplify().toString();

            if (simpStr.equals("1.0") || simpStr.equals("1"))
            {
                gradePart2++;
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

            // e^3x / e^x = e^2x
            // x = 0.5
            // result is : e^1 = 2.718
            // Accepted answers are in the range : value >= 2.7 && value <= 2.8

            e = new Div( 		new Pow(new Var("e"), new Mult(new Var("x") , new Num(3))) ,
                    new Pow(new Var("e"), new Var("x")) );
            assignment.clear();
            assignment.put("x", 0.5);
            assignment.put("e", 2.71);
            value = e.evaluate(assignment);
            value  = Double.parseDouble(new DecimalFormat("##.###").format(value));

            if (value >= 2.7 && value <= 2.8)
            {
                gradePart2++;
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

        System.out.println("Total cases part 2:" + caseNumber + "\n");

        return gradePart2;
    }

}
