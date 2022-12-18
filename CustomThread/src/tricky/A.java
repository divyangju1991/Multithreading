package tricky;

public class A implements Runnable {

	public synchronized void m1(){
		try {
			System.out.println("Before Sleep Thread Name : "+Thread.currentThread().getName());
			Thread.sleep(5000);
			System.out.println("After Sleep Thread Name : "+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		m1();
	} 
}
