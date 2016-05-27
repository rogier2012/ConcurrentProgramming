package block1.ex2;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by Rogier on 19-04-16 in Enschede.
 */
public class LinkedQueue<T> implements Queue<T>{
    private LinkedList<T> list;
    private volatile int available;
    private int maximum = 4;

    LinkedQueue(int maximum) {
        list = new LinkedList<>();
        available = 0;
        this.maximum = maximum;
    }

    @Override
    public synchronized void push(T x) {
        while (available > maximum){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.addFirst(x);
        available++;
        notifyAll();
    }

    @Override
    public synchronized T pull() throws QueueEmptyException {
        while(available==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            available--;
            notifyAll();
            return list.removeLast();
        } catch (NoSuchElementException e){
            throw new QueueEmptyException();
        }
    }

    @Override
    public int getLength() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
