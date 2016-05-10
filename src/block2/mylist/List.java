package block2.mylist;

/**
 * Created by Rogier on 02-05-16 in Enschede.
 */
public interface List<T> {
    public void insert(int pos, T val); public void add(T val);
    public void remove(T item);
    public void delete(int pos);
    public int size();
    public String toString ();
}