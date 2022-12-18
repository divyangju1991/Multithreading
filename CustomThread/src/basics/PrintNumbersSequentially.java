package basics;

class Printer implements Runnable {
	static int counter = 1;
	
	public void printer(){
		System.out.println(Thread.currentThread().getName() +" : "+ (counter++));
	}
	
	@Override
	public void run(){
		for(int i=0; i<5; i++){
			printer();	
		}
	}
}

public class PrintNumbersSequentially {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Printer oddObject = new Printer();
		Printer evenObject = new Printer();
		Thread oddThread = new Thread(oddObject, "ODD Thread");
		Thread evenThread = new Thread(evenObject, "Even Thread");
	
		oddThread.start();
		evenThread.start();
	}

}
