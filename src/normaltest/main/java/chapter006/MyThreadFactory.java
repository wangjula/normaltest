package normaltest.main.java.chapter006;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setUncaughtExceptionHandler(new MyUncatchExceptionHandler());
		return t;
	}

}
