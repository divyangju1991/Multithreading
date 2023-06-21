package reneterantFailedApproach;

import java.util.concurrent.locks.*;
public class PrintSequence implements Runnable {

	private Printer printer;
	private int reminder;
	private ReentrantLock lock = new ReentrantLock();
	private Condition oddCondition = lock.newCondition();
	private Condition evenCondition = lock.newCondition();
	
	public PrintSequence(Printer printer, int reminder){
		this.printer = printer;
		this.reminder = reminder;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<5; ++i){
			lock.lock();
				try {
					evenCondition.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				printer.oddPrint();
				evenCondition.signal();
				lock.unlock();
				lock.lock();
				try {
					oddCondition.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				printer.evenPrint();
				oddCondition.signal();
			lock.unlock();
		}
	}
}
