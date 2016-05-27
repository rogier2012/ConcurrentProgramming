package block4.ex1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Rogier on 19-05-16 in Enschede.
 */
public class CompareAndSet implements BasicLock {
    private AtomicInteger lockTakenByThread;

    public CompareAndSet() {
        lockTakenByThread = new AtomicInteger(-1);

    }

    @Override
    public void lock(int thread_nr) {
        while (!this.lockTakenByThread.compareAndSet(-1,thread_nr)){
            ;
        }
        return;
    }

    @Override
    public void unlock(int thread_nr) {
        this.lockTakenByThread.set(-1);
    }
}
