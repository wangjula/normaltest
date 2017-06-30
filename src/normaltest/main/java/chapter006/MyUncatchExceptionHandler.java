package normaltest.main.java.chapter006;

public class MyUncatchExceptionHandler implements Thread.UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("Thread:" + t.getName() +" catch a uncaughtException");
	}

}
