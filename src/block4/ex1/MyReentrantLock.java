package block4.ex1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Rogier on 19-05-16 in Enschede.
 */
public class MyReentrantLock implements BasicLock {
    private Lock lock;

    public MyReentrantLock() {
        this.lock = new ReentrantLock();
    }

    @Override
    public void lock(int thread_nr) {
        lock.lock();
    }

    @Override
    public void unlock(int thread_nr) {
        lock.unlock();
    }
}
