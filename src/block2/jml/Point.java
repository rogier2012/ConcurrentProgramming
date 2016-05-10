package block2.jml;

public class Point {
	/*@ spec_public */private int x;
	/*@ spec_public */private int y = 1;
	//@ public invariant x != y;

	private final static Object lockXY = new Object();
//	private Object lockY = new Object();

	//@ ensures \result >= 0; 
	/*@ pure */public int getX() {
		synchronized (lockXY) {
			return x;
		}
	}

	//@ ensures \result >= 0; 
	/*@ pure */public int getY() {
		synchronized (lockXY) {
			return y;
		}
	}

	/*@ requires n >= 0;
	 *  ensures getX() == \old(getX()) || getX() == \old(getX()) + n; */
	public void moveX(int n) {
		boolean b;
		synchronized (lockXY) {
			b = (x + n != y);

		}
		synchronized (lockXY) {
			if (b) {
				x = x + n;
			}
		}
	}

	/*@ requires n >= 0;
	 *  ensures getY() == \old(getY()) || getY() == \old(getY() + n); */
	public void moveY(int n) {
		boolean b;
		synchronized (lockXY) {
			b = (x != y + n);
		}
		synchronized (lockXY) {
			if (b) {
				y = y + n;
			}
		}
	}
}
