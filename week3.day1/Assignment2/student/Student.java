package org.student;

import org.department.Department;

//inherit using extends keyword using multilevel inheritance and import qualified full name from other package
public class Student extends Department
{
  public void studentName()
  {
	  System.out.println("karthik..");
  }
  public void studentDept()
  {
	  System.out.println("Mechanical Department ");
  }
  public void studentId()
  {									
	  System.out.println("410714114045");
  }
  
  public static void main(String[] args) 
  {
	//new = instance of the object
	//student() = constructor call
	//obj = object reference variables
	Student obj = new Student();
	obj.collegeName();
	obj.collegeCode();
	obj.collegeRank();
	obj.deptName();
	obj.studentName();
	obj.studentDept();
	obj.studentId();
	
  }
}
