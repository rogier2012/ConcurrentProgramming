package block2.mylist;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Rogier on 02-05-16 in Enschede.
 */
public class Node<T> {
    private T data;
    private Lock lock;
    private Node next;

    public Node(T data) {
        this.data = data;
        this.lock = new ReentrantLock();
    }

    public void setNext(Node<T> next) {
        synchronized (this) {
            this.next = next;
        }

    }

    public Node<T> getNext() {
        synchronized (this) {
            return next;
        }

    }

    public void lock(){
        lock.lock();
    }

    public void unlock(){
        lock.unlock();
    }

}


