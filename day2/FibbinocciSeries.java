package week1.day2;


public class FibbinocciSeries 
{
  public static void main(String[] args) 
  {
	//To print Fibbinocci series from 
    int firstNum =0,secNum=1,sum=0;
    System.out.print(firstNum +", "+secNum);
    for (int i = 1; i <10; i++) 
    {
		sum = firstNum + secNum;
		System.out.print(", "+sum);
		firstNum = secNum;
		secNum =sum;
		
	}
    
  }
}
