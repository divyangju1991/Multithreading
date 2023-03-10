package tricky;

public class ThreadsCalling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		A o1 = new A();
		A o2 = new A();
		
		Thread t1 = new Thread(o1, "Thread-1");
	    Thread t2 = new Thread(o2, "Thread-2");		
		
	    t1.start();
	    t2.start();
	    
	    B b1 = new B(1);
		B b2 = new B(2);
		
		Thread t3 = new Thread(b1, "Thread-3");
	    Thread t4 = new Thread(b2, "Thread-4");		
		
	    t3.start();
	    t4.start();
	    
	    o1 = new A();
		o2 = new A();
		
		t1 = new Thread(o1, "Re-Thread-1");
	    t2 = new Thread(o2, "Re-Thread-2");		
		
	    t1.start();
	    t1.join();
	    t2.start();
	}

}
