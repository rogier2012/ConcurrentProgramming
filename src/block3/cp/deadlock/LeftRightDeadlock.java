package block3.cp.deadlock;

/**
 * Created by Rogier on 10-05-16.
 */
public class LeftRightDeadlock {
    private final Object left = new Object();
    private final Object right = new Object();
    private int counter = 0;

    public void leftRight(){
        synchronized (left){
            synchronized (right){
                counter++;
            }
        }
    }

    public void rightLeft(){
        synchronized (right){
            synchronized (left){
                counter--;
            }
        }
    }
}
