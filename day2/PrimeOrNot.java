package week1.day2;

import java.util.Scanner;

public class PrimeOrNot 
{
	public static void main(String[] args) 
	{
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int n = scn.nextInt();
		int i, count = 0;
		for(i=2; i<n/2; i++) 
		{
			if(n%i==0)
			{
				count++;
				break;
			}
		}
		if(count==0)
		    System.out.println("The number is prime number");
		else
			System.out.println("The number is not primeNumber");
		
		
	}

}
