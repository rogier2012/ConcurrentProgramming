package block5;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Rogier on 27-05-16.
 */
public class MyLockFreeStack<T> implements LockFreeStackInterface<T> {
    AtomicReference<Node<T>> head ;
    AtomicInteger length ;
    private int maxLength;

    public MyLockFreeStack(int maxLength) {
        this.maxLength = maxLength;
        head = new AtomicReference<>();
        length = new AtomicInteger(0);
    }

    @Override
    public void push(T x) {
        if (this.getLength() >= this.maxLength){
            System.out.println("Stack overflow");
        }

        Node<T> newHead = new Node<T>(x);
        Node<T> oldHead;
        do {
            oldHead = head.get();
            newHead.next = oldHead;
        } while (!head.compareAndSet(oldHead, newHead));
        this.length.incrementAndGet();
    }

    @Override
    public T pop() {
        Node<T> oldHead;
        Node<T> newHead;
        do {
            oldHead = head.get();
            if (oldHead == null) {
                System.out.println("Stack is empty");
                return null;
            }
            newHead = oldHead.next;
        } while (!head.compareAndSet(oldHead, newHead));
        this.length.decrementAndGet();
        return oldHead.item;
    }

    @Override
    public int getLength() {
        return length.intValue();
    }


    static class Node<T> {
        final T item;
        Node<T> next;
        public Node(T item){
            this.item = item;
        }

    }
}
