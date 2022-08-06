package week1.day1;

public class TwoWheeler 
{
 
	int noOfWheels = 4;
	short noOfMirrors = 2;
	long chassisNumber = 563869374583l;
	boolean isPunctured = false;
	String bikeName = "Xpulse 4V";
	static double runningKM = 4000d;
 
	public static void main(String[] args) 
    {
	 TwoWheeler obj = new TwoWheeler();
	 System.out.println("Number of wheels : "+obj.noOfWheels);
	 System.out.println("Number of mirrors : "+obj.noOfMirrors);
	 System.out.println("Chassis Number : "+obj.chassisNumber);
	 System.out.println("Is punctured : "+obj.isPunctured);
	 System.out.println("Bike Name : "+obj.bikeName);
	 System.out.println("Total runned KM : "+TwoWheeler.runningKM);
    }
}
