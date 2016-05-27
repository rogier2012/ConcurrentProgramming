package block4.ex1;

/**
 * Created by Rogier on 19-05-16 in Enschede.
 */
public interface BasicLock {


    public void lock(int thread_nr);

    public void unlock(int thread_nr);
}
