package tricky;

public class B implements Runnable {
	
	private int order;
	public B(int order){
		this.order = order;
	}

	
	public static synchronized void m1(){
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
