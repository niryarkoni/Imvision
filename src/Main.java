import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
//        Expression e = new Pow(0, 0);
//        System.out.println(e.simplify());
//        int p1 = ExpressionTestPart1.main1();
//        int p2 = ExpressionTestPart2.main2();
//        int p3 = ExpressionTestPart3.main3();
//        System.out.println("Final grade :" + p1);
//        System.out.println("Final grade :" + p2);
//        System.out.println("Final grade :" + p3);
        long n = 1000;
        Expression e = new Plus(new Div(new Var("n"),new Num(2)), new Pow(new Var("n"),new Num(2)));
        Executor exc = new Executor(e,n);
        List<Double> res = exc.excute();
        //print result
        for(long i=0; i<res.size();i++){
            System.out.println("index "+i +": "+ res.get((int)i));
        }

    }
}
