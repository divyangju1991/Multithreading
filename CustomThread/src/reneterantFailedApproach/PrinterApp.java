package reneterantFailedApproach;

public class PrinterApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Printer printer = new Printer();
		PrintSequence odd = new PrintSequence(printer, 1);
		PrintSequence even = new PrintSequence(printer, 0);
		Thread t1 = new Thread(odd, "ODD Thread");
		Thread t2 = new Thread(even, "Even Thread");
		//t1.start();
		//t2.start();
		
		System.out.println("\n\n================Start Printer with Synchronized Approach =============\n\n");
		
		
		PrintSequenceNormal odd1 = new PrintSequenceNormal(printer, 1);
		PrintSequenceNormal even1 = new PrintSequenceNormal(printer, 0);
		Thread tt1 = new Thread(odd1, "ODD Thread");
		Thread tt2 = new Thread(even1, "Even Thread");
		tt1.start();
		tt2.start();
		
		while(true){
			if(printer.num.get() >= 10){
				System.out.println("\n\n================End Printer with Synchronized Approach=============\n\n");
				break;
			}			
		}		
	}
}
