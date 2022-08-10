package week1.day2;

public class Car 
{
  
  public void carBrand()
  {
	  System.out.println("The brand of the car is Hyundai Creta");
  }
  public String getCarColour()
  {
	return "White";	  
  }
  public long getCarEngineeNo()
  {
	 return 84647837; 
  }
  public int getSub(int x,int y)
  {
	  int ans1= x*y;
	  return ans1;
  }
  public int getMultiplication(int a,int b)
  {
	  int ans1=a*b;
	  return ans1;
  }
  public int getDivision(int a,int b)
  {
	  int ans1=a/b;
	  return ans1;
  }
  
  public static void main(String[] args) 
  {
	Car obj = new Car();
	obj.carBrand();
	System.out.println("The colour of the car is : "+obj.getCarColour());
	System.out.println("The enginee number of car is : "+obj.getCarEngineeNo());
	System.out.println("The subtraction od two numbers is : "+obj.getSub(23, 34));
	System.out.println("The Multiplication od two numbers is : "+obj.getMultiplication(3, 15));
	System.out.println("The division od two numbers is : "+obj.getDivision(20, 4));
  }
 
}
