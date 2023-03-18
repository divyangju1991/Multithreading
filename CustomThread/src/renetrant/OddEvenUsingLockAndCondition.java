package renetrant;

public class OddEvenUsingLockAndCondition {

	public static void main(String[] args) {
		  
		  OddEvenImpl obj = new OddEvenImpl();
		  
		  OddPrint odd = new OddPrint(obj);
		  EvenPrint even = new EvenPrint(obj);
		 
		  Thread oddThread = new Thread(odd, "Odd Thread");
		  Thread evenThread = new Thread(even, "Even Thread");

		  oddThread.start();
		  try {
			   Thread.sleep(500);
			  } catch (InterruptedException e) {
			   e.printStackTrace();
			  }
		  evenThread.start();
	}	
}
