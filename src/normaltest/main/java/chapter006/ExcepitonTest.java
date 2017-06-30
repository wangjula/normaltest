package normaltest.main.java.chapter006;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExcepitonTest {

	public static void main(String[] args) {

		ExecutorService exec = Executors.newCachedThreadPool(new MyThreadFactory());
		exec.execute(new ExceptionTask());
		exec.shutdown();
	}

}
