import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Executor {
    private Expression expression;
    private long N;
    public Executor(Expression e, long n){
        this.expression = e;
        this.N = n;
    }
    public List<Double> excute(){
        //create pool
        ExecutorService service = Executors.newCachedThreadPool();
        //submit the tasks for execution
        //List<Double> futuresValues = new ArrayList<>();
        List<Future> futuresList = new ArrayList<>();
        List<Double> result = new ArrayList<>();
        for (int i= 0;i<N;i++){
            Future<Double> future = service.submit(new Task(expression,i));
            futuresList.add(future);
            //futuresValues.add(future.get(1, TimeUnit.SECONDS));
        }

        for(Future<Double> f : futuresList){
            try {
                result.add(f.get(1,TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    static class Task implements Callable<Double> {
        private Expression e;
        private int index;
        public Task(Expression expression, int n_value){
            this.e = expression;
            this.index = n_value;
        }
        @Override
        public Double call() throws Exception {
            Expression ex = this.e.assign("n",new Num(this.index));
            return ex.evaluate();
        }
    }
}
