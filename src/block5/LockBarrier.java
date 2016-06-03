package block5;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Rogier on 27-05-16 in Enschede.
 */
public class LockBarrier implements Barrier {
    private final int height;
    private int status;

    public LockBarrier(int height) {
        this.height = height;
        this.status = height;
    }

    @Override
    public synchronized int await() throws InterruptedException {
        int setStatus = --status;
        if (status == 0){
            status = height;
            notifyAll();
        } else {
            wait();
        }
        return setStatus;
    }
}
