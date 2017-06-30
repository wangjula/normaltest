package normaltest.main.java.chapter001;

import java.util.Random;

public class IntegerGenerator implements Generator<Integer> {

	private static Random rand = new Random(47);
	
	private int bound;
	
	public IntegerGenerator(int bound) {
		if (bound < 0) {
			bound = 0;
		}
		this.bound = bound;
	}
	
	@Override
	public Integer next() {
		return rand.nextInt(bound);
	}

}
