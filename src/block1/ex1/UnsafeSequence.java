package block1.ex1;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Rogier on 19-04-16.
 */
public class UnsafeSequence {
    private AtomicInteger value;

    public UnsafeSequence() {
        this.value = new AtomicInteger(0);
    }

    public int getNext() {
        return value.incrementAndGet();
    }

    public int getValue() {
        return value.intValue();
    }
}
