package normaltest.main.java.chapter007;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author wangjl
 *
 * @time 2017年6月29日
 * 
 * productor1: 制作吐司干片
 *
 */
public class Toaster implements Runnable {
	
	private ToastQueue toastQueue;
	
	private int count = 0;
	
	public Toaster(ToastQueue queue) {
		this.toastQueue = queue;
	}

	@Override
	public void run() {

		try {
			while (!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(100 + new Random(47).nextInt(1000));
				Toast t = new Toast(count++);
				System.out.println(t);
				toastQueue.put(t);
			}
		} catch (InterruptedException e) {
			System.out.println("Toaster is interrupted!");
		}
		System.out.println("Toaster off");
	}

}
