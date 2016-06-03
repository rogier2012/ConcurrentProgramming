package block5;

/**
 * Created by Rogier on 27-05-16 in Enschede.
 */
public interface Barrier {
    public int await() throws InterruptedException;
}
