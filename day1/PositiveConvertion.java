package week1.day1;

import java.util.Scanner;

public class PositiveConvertion
{
  public static void main(String[] args) 
  {
	Scanner scn = new Scanner(System.in);
	System.out.print("Enter the number : ");
	int No = scn.nextInt();
	
	if(No<0)
	{
		No = No-No-No;
		System.out.println("Converted Positive no is : "+No);
	}
	else
		System.out.println("The number is positive Only");
  }
}
