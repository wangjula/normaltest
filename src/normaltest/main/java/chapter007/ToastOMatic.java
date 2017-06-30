package normaltest.main.java.chapter007;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author wangjl
 *
 * @time 2017年6月29日
 *
 */
public class ToastOMatic {

	//使用BlockingQueue测试，生产者put数据，消费者take数据
	public static void main(String[] args) throws InterruptedException {
		ToastQueue dryQueue = new ToastQueue();
		ToastQueue butterQueue = new ToastQueue();
		ToastQueue finishedQueue = new ToastQueue();
		
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new Toaster(dryQueue));
		exec.execute(new Butter(dryQueue, butterQueue));
		exec.execute(new Jammer(butterQueue, finishedQueue));
		exec.execute(new Eater(finishedQueue));
		exec.shutdown();
		Thread.sleep(10000);
		exec.shutdownNow();
	}

}
