import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int n = 100; // Enter the N value
        // Enter the math function
        Expression e = new Plus(new Div(new Var("n"),new Num(2)), new Pow(new Var("n"),new Num(2)));
        Executor exc = new Executor(e,n);
        List<Double> res = exc.excute();
        //print result
        for(int i=0; i<res.size();i++){
            System.out.println("index "+i +": "+ res.get(i));
        }

    }
}
