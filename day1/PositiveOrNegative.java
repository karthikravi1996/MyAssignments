package week1.day1;

import java.util.Scanner;

public class PositiveOrNegative 
{
  public static void main(String[] args) 
  {
    Scanner scn = new Scanner(System.in);
    System.out.print("Enter the number : ");
    int num = scn.nextInt();
	if(num>0)
		System.out.println("It is positive number");
	if(num<0)
		System.out.println("It is negative number");
   }
}
