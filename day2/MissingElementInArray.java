package week1.day2;

import java.util.Arrays;

public class MissingElementInArray 
{
  public static void main(String[] args) 
  {
	//To find missing numbers from 1 to 8 in given array
	int[] arr = {1,2,3,4,7,6,8};
	int ref = 0;
	Arrays.sort(arr);
	for (int i = 0; i <=arr.length; i++) 
	{
		if(arr[ref] != i)
		{
			//here comparing index with each iteration.
			System.out.println("Missing number are : " + i);
		} 
		else
			ref++;
	}
	
  }
}
