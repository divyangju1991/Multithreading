package tricky;

public class TestImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestA testA = new TestA();
		Thread t1 = new Thread(testA, "Thread-0");
		Thread t2 = new Thread(testA, "Thread-1");
		Thread t3 = new Thread(testA, "Thread-2");
		t1.start();
		t2.start();
		t3.start();
	}

}
