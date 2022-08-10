package week1.day2;

public class MyCalculator 
{
 public static void main(String[] args) 
 {
   Calculator obj = new Calculator();
   System.out.println("The addition of three numbers is     : "+obj.add(5, 5, 5));
   System.out.println("The Subtraction of two numbers is    : "+obj.sub(10, 5));
   System.out.println("The multiplication of two numbers is : "+obj.mul(5, 5));
   System.out.println("The division of two  numbers is      : "+obj.divide(40, 5));
   
 }
}
