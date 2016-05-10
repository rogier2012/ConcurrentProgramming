package block1.ex2;

/**
 * Created by Rogier on 19-04-16.
 */
public interface Queue<T> {
    /** Push an element at the head of the queue. */
    void push(T x);

    /** Obtain and remove the tail of the queue. */

    T pull() throws QueueEmptyException;
    /** Returns the number of elements in the queue. */

    int getLength();
}
