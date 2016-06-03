package block6.cp;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by Rogier on 03-06-16.
 */
public class FibonacciCallable implements Callable<Integer> {
    private int n;
    private ExecutorService executorService;

    public FibonacciCallable(int n, ExecutorService executorService) {
        this.n = n;
        this.executorService = executorService;
    }

    @Override
    public Integer call() throws Exception {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            try {
                Callable n1 = new FibonacciCallable(n - 1, executorService);
                Callable n2 = new FibonacciCallable(n - 2, executorService);

                Future<Integer> result1 = executorService.submit(n1);
                Future<Integer> result2 = executorService.submit(n2);

                return result1.get() + result2.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
