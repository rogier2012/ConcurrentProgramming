package block6.cp;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Rogier on 03-06-16 in Enschede.
 */
public class FibRecursiveTask extends RecursiveTask<Integer> {
    private int n;

    public FibRecursiveTask( int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n > 2){
            FibRecursiveTask f1 = new FibRecursiveTask(n-1);
            f1.fork();
            FibRecursiveTask f2 = new FibRecursiveTask(n-2);
            return f2.compute() + f1.join();
        } else {
            return 1;
        }
    }
}
