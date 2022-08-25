package org.system;

//inherit using extends keyword using single inheritance inside same package 
public class Desktop extends Computer
{
   public void desktopSize()
   {
	 System.out.println("21 inch");
   }
  public static void main(String[] args) 
  {
	Desktop obj2 = new Desktop();
	obj2.desktopSize();
	obj2.computerModel();
  }
}
