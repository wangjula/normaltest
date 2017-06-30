package normaltest.main.java.chapter001;

import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		int[] arr1 = new int[]{1,2,3,4,5};
		int[] arr2 = new int[5];
		System.arraycopy(arr1, 0, arr2, 1, 4);
		System.out.println(Arrays.toString(arr2));
		Generator<Integer> gen = new IntegerGenerator(100);
		Number[] nArr = new Integer[2];//数组协变性
		for (int i = 0; i < arr2.length; i ++) {
			arr2[i] = gen.next();
		}
		System.out.println(Arrays.toString(arr2));
		
	}

}
