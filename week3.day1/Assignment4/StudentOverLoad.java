package assignement4;

public class StudentOverLoad 
{
  public void getStudentInfo(int id)
  {
	  System.out.println("It consists only ID argument");
	  System.out.println("ID info is : "+id);
	  System.out.println("==================================");
  }
  public void studentInfo(int id,String name)
  {
	  System.out.println("It had both id and name");
	  System.out.println("ID info is : "+id+" // Name is "+name);  
	  System.out.println("==================================");

  }
  public void studentInfo(String emailId, long phoneNumber)
  {
	  System.out.println("This method consists of emailid and phone number");
	  System.out.println("emailId is : "+emailId+" // phonenumber is : "+phoneNumber);
	  System.out.println("==================================");

  }
  public static void main(String[] args) 
  {
	StudentOverLoad obj = new StudentOverLoad();
	obj.getStudentInfo(4046);
	obj.studentInfo(4046,"karthik");
	obj.studentInfo("karthikravi576@gmail.com", 866725032);
  }
}
