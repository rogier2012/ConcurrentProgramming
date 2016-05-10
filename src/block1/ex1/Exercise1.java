package block1.ex1;

/**
 * Created by Rogier on 19-04-16.
 */
public class Exercise1 {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            UnsafeSequence seq = new UnsafeSequence();
            Thread t1 = new MyThread(seq);
            Thread t2 = new MyThread(seq);
            Thread t3 = new MyThread(seq);
            Thread t4 = new MyThread(seq);
            Thread t5 = new MyThread(seq);
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t5.start();
            try {
                t1.join();
                t2.join();
                t3.join();
                t4.join();
                t5.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(seq.getValue());
        }
    }
}

