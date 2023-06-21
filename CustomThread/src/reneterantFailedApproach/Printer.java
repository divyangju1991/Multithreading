package reneterantFailedApproach;
import java.util.concurrent.atomic.*;

public class Printer {

	/*
	public static AtomicInteger oddNumber = new AtomicInteger(1);
	public static AtomicInteger evenNumber = new AtomicInteger(2);
	*/
	public static volatile int oddNumber = -1;
	public static volatile int evenNumber = 0;
	public static AtomicInteger num = new AtomicInteger(1);
	
	public void oddPrint(){
		oddNumber +=2 ;
		System.out.println(Thread.currentThread().getName()+" "+(oddNumber));
	}
	
	public void evenPrint(){
		evenNumber += 2;
		System.out.println(Thread.currentThread().getName()+" "+(evenNumber));
	}
	
	public void print(){
		System.out.println(Thread.currentThread().getName()+" "+(num.getAndIncrement()));
	}
}
