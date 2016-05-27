package block4.ex1;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by Rogier on 19-05-16 in Enschede.
 */
public class MyBasicLock implements BasicLock{
    private AtomicIntegerArray array ;
    private int turn;

    public MyBasicLock() {
        array = new AtomicIntegerArray(2);
        array.set(0,0);
        array.set(1,0);
        turn = 0;
    }

    @Override
    public void lock(int thread_nr) {
        int j = 1 - thread_nr;
        array.set(thread_nr,1);
        if(array.get(j) == 1)
        {
            while (turn!=thread_nr)
            {
            }
        }
    }

    @Override
    public void unlock(int thread_nr) {
        array.set(thread_nr,0);
        turn = 1 - thread_nr;
    }
}
