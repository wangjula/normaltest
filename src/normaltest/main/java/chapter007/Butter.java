package normaltest.main.java.chapter007;

/**
 *
 * @author wangjl
 *
 * @time 2017Äê6ÔÂ29ÈÕ
 *
 * productor2: Í¿»ÆÓÍ
 *
 */
public class Butter implements Runnable {

	private ToastQueue dryQueue;
	
	private ToastQueue butterQueue;
	
	public Butter(ToastQueue dryQueue, ToastQueue butterQueue) {
		this.dryQueue = dryQueue;
		this.butterQueue = butterQueue;
	}
	
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Toast dryToast = dryQueue.take();
				dryToast.butter();
				System.out.println(dryToast);
				butterQueue.put(dryToast);
			}
		} catch (InterruptedException e) {
			System.out.println("Butter interrupted!");
		}
		System.out.println("Butter off");
	}

}
