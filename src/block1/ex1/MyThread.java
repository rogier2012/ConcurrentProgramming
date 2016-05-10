package block1.ex1;

/**
 * Created by Rogier on 19-04-16.
 */
public class MyThread extends Thread{
    private UnsafeSequence seq;

    public MyThread(UnsafeSequence seq) {
        this.seq = seq;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10000; i++) {
                seq.getNext();
        }

    }
}
