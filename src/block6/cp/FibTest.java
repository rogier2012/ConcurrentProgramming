package block6.cp;

import java.util.concurrent.*;

/**
 * Created by Rogier on 03-06-16 in Enschede.
 */
public class FibTest {


    public static void main(String[] args) {
        FibTest fibTest = new FibTest();
        fibTest.testCallable();
        fibTest.testRecursiveTask();
    }


    public void testCallable(){
        int n = 10;
        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            Future<Integer> result = executorService.submit(new FibonacciCallable(n,executorService));
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }


    public void testRecursiveTask(){
       int n = 40;
        Integer result = ForkJoinPool.commonPool().invoke(new FibRecursiveTask(n));
        System.out.println(result.intValue());
    }

}
