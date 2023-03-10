package basics;

class Printer2 implements Runnable {
	static int counter = 1;
	static Object lock = new Object();
	int reminder;
	
	public Printer2(int reminder){
		this.reminder = reminder;
	}
	
	public void printer(){
		System.out.println(Thread.currentThread().getName() +" : "+ (counter++));
	}
	
	@Override
	public void run(){
		
		synchronized(lock){
			for(int i=0; i<5; i++){
				if(counter%2 != reminder){
					try {
						lock.wait();	
					} catch(InterruptedException ex){
						
					}
				}
				printer();
				lock.notifyAll();
			}
		}
	}
}

public class PrintNumbersOddEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Printer2 oddObject = new Printer2(1);
		Printer2 evenObject = new Printer2(0);
		Thread oddThread = new Thread(oddObject, "ODD Thread");
		Thread evenThread = new Thread(evenObject, "Even Thread");
	
		oddThread.start();
		evenThread.start();
	}

}
