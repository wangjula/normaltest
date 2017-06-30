package normaltest.main.java.chapter007;
/**
 *
 * @author wangjl
 *
 * @time 2017年6月29日
 *
 * productor3: 涂果酱
 * 
 */
public class Jammer implements Runnable {
	
	private ToastQueue butterQueue;
	
	private ToastQueue finishedQueue;
	
	public Jammer(ToastQueue butterQueue, ToastQueue finishedQueue) {
		this.butterQueue = butterQueue;
		this.finishedQueue = finishedQueue;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Toast butteredToast = butterQueue.take();
				butteredToast.jam();
				System.out.println(butteredToast);
				finishedQueue.put(butteredToast);
			}
		} catch (InterruptedException e) {
			System.out.println("Jammer interrupted");
		}
		System.out.println("Jammer off");
	}

}
