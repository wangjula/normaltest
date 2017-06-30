package normaltest.main.java.chapter006;

public class ExceptionTask implements Runnable {

	@Override
	public void run() {
		throw new RuntimeException();
	}

}
