import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Executor {
    private Expression expression;
    private int N;
    public Executor(Expression e, int n){
        this.expression = e;
        this.N = n;
    }
    public List<Double> excute(){
        //create pool
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        List<Future> futuresList = new ArrayList<>();
        List<Double> result = new ArrayList<>(); // result list
        int groupCount = N/coreCount; // number of values for submitting task
        int index = 0; // initilaze index to zero

        //submit the tasks for execution
        while (index <= N-1){
            int first = index; // first index of the group
            int last = Math.min(index+groupCount,N-1); // last index of the group
            Future<List<Double>> futures = service.submit(new Task(expression,first,last));
            futuresList.add(futures);
            index += groupCount+1;
        }

        for(Future<List<Double>> f : futuresList){
            try {
                List<Double> values = f.get(1,TimeUnit.SECONDS);
                result.addAll(values);
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

    static class Task implements Callable<List<Double>> {
        private Expression e;
        private int firstIndex;
        private int lastIndex;
        private List<Double> group= new ArrayList<Double>();
        public Task(Expression expression, int first, int last){
            this.e = expression;
            this.firstIndex = first;
            this.lastIndex = last;
        }
        @Override
        public List<Double> call() throws Exception {
            for (int i=firstIndex; i<=lastIndex;i++){
                try{
                    Expression ex = this.e.assign("n",new Num(i));
                    group.add(ex.evaluate());
                }
                catch (Exception e){
                    group.add(null);
                    e.printStackTrace();
                }

            }
            return group;
        }
    }
}
