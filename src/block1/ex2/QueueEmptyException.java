package block1.ex2;

/**
 * Created by Rogier on 19-04-16.
 */
public class QueueEmptyException extends Exception {
    public QueueEmptyException() {
        super("Queue is empty!");
    }
}
