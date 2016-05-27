package block5;

/**
 * Created by Rogier on 27-05-16.
 */
public class ProdCons implements Runnable{
    private LockFreeStackInterface<Integer> stack;

    public ProdCons(LockFreeStackInterface<Integer> stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            stack.pop();
            stack.push(i);
        }
    }
}
