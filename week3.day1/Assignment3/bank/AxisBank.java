package bank;

public class AxisBank extends BankInfo
{
  public void deposit()
  {
	  System.out.println("deposited the initial amount of ****  in axis bank account");
  }
  public static void main(String[] args) 
  {
	AxisBank obj = new AxisBank();
	obj.savings();
	obj.fixed();
	//where deposit method override
	obj.deposit();
  }
}
