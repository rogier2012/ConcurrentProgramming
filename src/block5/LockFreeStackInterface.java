package block5;

/**
 * Created by Rogier on 27-05-16.
 */
public interface LockFreeStackInterface<T> {
    public void push(T x);
    public T pop();
    public int getLength();

}
