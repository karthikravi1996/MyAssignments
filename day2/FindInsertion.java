package week1.day2;

public class FindInsertion 
{
	public static void main(String[] args) 
	{
		int[] arr1 = {3,2,11,4,6,7};
		int[] arr2 = {1,2,8,4,9,7};
		//By using nested for loop compare the insertion number 
		for (int i = 0; i < arr1.length; i++) 
		{
			for (int j = 0; j < arr2.length; j++) 
			{
				//By using comparison operator
				if(arr1[i]==arr2[j])
					System.out.println("The interstion numbers from 2 sets of array is : "+arr2[j]);
			}
		}
	}
}
