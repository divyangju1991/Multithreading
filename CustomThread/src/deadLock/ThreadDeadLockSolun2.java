package deadLock;

public class ThreadDeadLockSolun2 {
	
	public static void test(){
		
		String s1 = "Divyang";
		String s2 = "Upadhyay";
		
		Runnable r1 = () -> {
			while(true){
				synchronized (s1) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (s2) {
						System.out.println(s1 + " "+s2);
					}
				}
			}
			
		};
		
		Runnable r2 = () -> {
			while(true){
				synchronized (s1) {
					synchronized (s2) {
						System.out.println(s1 + " "+s2);
					}
				}
			}
		};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}

}
