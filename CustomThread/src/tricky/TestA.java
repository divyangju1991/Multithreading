package tricky;

public class TestA implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//if(Thread.currentThread().getName().equals("Thread-0")){
			a();
		//} else if(Thread.currentThread().getName().equals("Thread-1")){
			b();
		//} else {
			c();
		//}
	}

	public synchronized void a(){
		try {
			System.out.println("a() Before Sleep Thread Name : "+Thread.currentThread().getName());
			Thread.sleep(5000);
			System.out.println("a() After Sleep Thread Name : "+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("A" + Thread.currentThread().getName());
	}
	
public synchronized void b(){
	try {
		System.out.println("b() Before Sleep Thread Name : "+Thread.currentThread().getName());
		Thread.sleep(5000);
		System.out.println("b() After Sleep Thread Name : "+Thread.currentThread().getName());
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("B" + Thread.currentThread().getName());
	}

public void c(){
	try {
		System.out.println("c() Before Sleep Thread Name : "+Thread.currentThread().getName());
		Thread.sleep(5000);
		System.out.println("c()After Sleep Thread Name : "+Thread.currentThread().getName());
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("C" + Thread.currentThread().getName());
}
	
}
