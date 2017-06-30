package normaltest.main.java.chapter007;
/**
 *
 * @author wangjl
 *
 * @time 2017年6月29日
 *
 *
 * Consumer: 消费吐司
 */
public class Eater implements Runnable {
	
	private ToastQueue finishedQueue;
	
	private int count = 0;
	
	public Eater(ToastQueue finishedQueue) {
		this.finishedQueue = finishedQueue;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Toast finishedToast = finishedQueue.take();
				if (finishedToast.getId() != count++ 
						|| !Status.JAMMED.equals(finishedToast.status())) {
					System.out.println(">>>>Err " + finishedToast);
					System.exit(1);
				}
				System.out.println("Chomp! " + finishedToast);
			}
		} catch (InterruptedException e) {
			System.out.println("eater interrupted!");
		}
		System.out.println("Eater off");
	}

}
