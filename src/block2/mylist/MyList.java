package block2.mylist;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Rogier on 02-05-16 in Enschede.
 */
public class MyList<T> implements List<T> {
    private Node<T> firstElem;


    @Override
    public void insert(int pos, T val) {
        int counter = 0;
        Node<T> elem = firstElem;
        Node<T> tmp = null;
        elem.lock();

        while (elem != null){
            tmp = elem;
            elem = elem.getNext();
            tmp.unlock();
            
        }
        elem = new Node<>(val);
        tmp.setNext(elem);
    }

    @Override
    public void add(T val) {

    }

    @Override
    public void remove(T item) {

    }

    @Override
    public void delete(int pos) {

    }

    @Override
    public int size() {
        return 0;
    }
}

