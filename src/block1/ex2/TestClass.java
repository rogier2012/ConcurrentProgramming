package block1.ex2;

/**
 * Created by Rogier on 19-04-16.
 */
public class TestClass {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {

            Queue<String> queue = new LinkedQueue<>(2);
            Producer prod1 = new Producer(queue);
            Producer prod2 = new Producer(queue);
            Producer prod3 = new Producer(queue);
            Consumer cons1 = new Consumer(queue,"Cons1");
            Consumer cons2 = new Consumer(queue,"Cons2");
            Consumer cons3 = new Consumer(queue,"Cons3");
            Thread t1 = new Thread(prod1);
            Thread t2 = new Thread(prod2);
            Thread t3 = new Thread(prod3);
            Thread t4 = new Thread(cons1);
            Thread t5 = new Thread(cons2);
            Thread t6 = new Thread(cons3);
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t5.start();
            t6.start();
            try{
                t1.join();
                t2.join();
                t3.join();
                t4.join();
                t5.join();
                t6.join();
            } catch (InterruptedException e){
                e.printStackTrace();

            }
        }





    }
}
