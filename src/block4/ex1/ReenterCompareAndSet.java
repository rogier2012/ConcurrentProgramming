package block4.ex1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Rogier on 19-05-16 in Enschede.
 */
public class ReenterCompareAndSet implements BasicLock{
    private AtomicInteger lock;
    private AtomicInteger numLocks;

    public ReenterCompareAndSet() {
        this.lock = new AtomicInteger(-1);
        this.lock = new AtomicInteger(0);
    }

    @Override
    public void lock(int thread_nr) {
        if (this.lock.get() == thread_nr){
            lock.incrementAndGet();
        }
        while(!this.lock.compareAndSet(-1,thread_nr)){

        }
        lock.set(1);
    }

    @Override
    public void unlock(int thread_nr) {
        this.lock.set(-1);

    }
}
