package block3.cp.queue;

import block1.ex2.Consumer;
import block1.ex2.LinkedQueue;
import block1.ex2.Producer;
import block1.ex2.Queue;

/**
 * Created by Rogier on 19-04-16.
 */
public class TestClass {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {

            Queue<String> queue = new ConLinkedQueue<>();
            Producer prod1 = new Producer(queue);
            Producer prod2 = new Producer(queue);
            Producer prod3 = new Producer(queue);
            Consumer cons1 = new Consumer(queue,"Cons1");
            Consumer cons2 = new Consumer(queue,"Cons2");
            Thread t1 = new Thread(prod1);
            Thread t2 = new Thread(prod2);
            Thread t3 = new Thread(prod3);
            Thread t4 = new Thread(cons1);
            Thread t5 = new Thread(cons2);
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t5.start();
            try{
                t1.join();
                t2.join();
                t3.join();
                t4.join();
                t5.join();
            } catch (InterruptedException e){
                e.printStackTrace();

            }
        }
        System.out.println((System.currentTimeMillis()-time));




    }
}
