package block1.ex2;

/**
 * Created by Rogier on 19-04-16.
 */
public class Consumer implements Runnable{
    private Queue<String> queue;
    private String name;


    public Consumer(Queue<String> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(queue.pull());
        } catch (QueueEmptyException e) {
            System.out.println(this.getName() + ": Queue empty");
        }
    }

    public String getName() {
        return name;
    }

}
