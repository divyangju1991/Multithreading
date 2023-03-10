package basics;

	class Printer3 implements Runnable {
		static int counter = 1;
		static Object lock = new Object();
		int reminder;
		
		public Printer3(int reminder){
			this.reminder = reminder;
		}
		
		public void printer(){
			System.out.println(Thread.currentThread().getName() +" : "+ (counter));
		}
		
		@Override
		public void run(){
			
			synchronized(lock){
				
					if(counter%2 != reminder){
						try {
							lock.wait();	
						} catch(InterruptedException ex){
							
						}
					}
					for(int i=1; i<5; i++, counter += 2){
						printer();
					}
					counter = reminder == 0 ? 1 : 2;
					lock.notifyAll();
		   }
		}
	}

	public class PrintNumbersOddEvenOneByOne {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Printer3 oddObject = new Printer3(1);
			Printer3 evenObject = new Printer3(0);
			Thread oddThread = new Thread(oddObject, "ODD Thread");
			Thread evenThread = new Thread(evenObject, "Even Thread");
		
			oddThread.start();
			evenThread.start();
		}

	}
