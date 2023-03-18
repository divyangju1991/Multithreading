package renetrant;

public class OddPrint implements Runnable {
	
	private OddEvenImpl printer;

	public OddPrint(OddEvenImpl printer){
		this.printer = printer;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		printer.printOdd();
	}
	
}
