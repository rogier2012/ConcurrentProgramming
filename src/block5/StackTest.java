package block5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Rogier on 27-05-16 in Enschede.
 */
public class StackTest {


    public static void main(String[] args) {
        StackTest stackTest = new StackTest();
        stackTest.test();


    }

    public void test(){
        List<Thread> threads = new ArrayList<>();
        LockFreeStackInterface<Integer> stack = new MyLockFreeStack<>();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(new ProdCons(stack));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(stack.getLength());
    }
}
