package scs;


import java.util.Scanner;
import java.sql.*;

public class JdbcExample3 {

	   int rno,fees;
	   String sname,branch;
	   Connection conn;
	   CallableStatement ps;
	   Scanner sc = new Scanner(System.in);
	   void accept(int rno,String sname,String branch,int fees)
	   {
		   this.rno=rno;
		   this.sname=sname;
		   this.branch = branch;
		   this.fees=fees;
	   }
	   
	    void connection() throws ClassNotFoundException,SQLException
	    {
	      Class.forName("com.mysql.jdbc.Driver");
	      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo","root","");
	     
	      
	    }
	    
	   void insertStudent() throws SQLException
	    {
	    	ps= conn.prepareCall("call insertstudent1(?,?,?,?)");
	    	ps.setInt(1,rno);
	    	ps.setString(2,sname);
	    	ps.setString(3,branch);
	    	ps.setInt(4,fees);
	    	int x = ps.executeUpdate();
	        if(x!=0)
	        {
	      	  System.out.println("Data Inserted Successfully");
	        }
	        else
	        {
	        	 System.out.println("Problem in Data Insertion");
	        }
	    }
	  /* void updateStudent() throws SQLException
	    {
	    	System.out.println("Enter rno to update reord");
	    	rno=sc.nextInt();
	    	 ps= conn.prepareStatement("update student set sname=?,branch=?,fees=? where rno=?");
	    	ps.setString(1,sname);
	    	ps.setString(2,branch);
	    	ps.setInt(3,fees);
	    	ps.setInt(4,rno);
	    	int x = ps.executeUpdate();
	        if(x!=0)
	        {
	      	  System.out.println("Data Updated Successfully");
	        }
	        else
	        {
	        	 System.out.println("Problem in Data Updation");
	        }
	    }
	    void deleteStudent() throws SQLException
	    {
	    	System.out.println("Enter rno to update reord");
	    	rno=sc.nextInt();
	    	ps= conn.prepareStatement("delete from student  where rno=?");
	    	ps.setInt(1,rno);
	    	int x = ps.executeUpdate();
	        if(x!=0)
	        {
	      	  System.out.println("Data Deleted Successfully");
	        }
	        else
	        {
	        	 System.out.println("Problem in Data Deletion");
	        }
	    }*/
	    void viewStudentRecord() throws SQLException
	    {
	    	CallableStatement ps= conn.prepareCall("{call viewallstudents()}");
	    	ResultSet res= ps.executeQuery();
	    	while(res.next())
	    	{
	    		System.out.println(res.getInt(1) + " ," + res.getString(2) + ","+ res.getString(3) + ","+ res.getInt(4));
	    	}
	    }
	    void closeConnection() throws SQLException
	    {
	    	conn.close();
	    }
		public static void main(String[] args) throws Exception {
			JdbcExample3 obj = new JdbcExample3();
			obj.accept(1009, "pcall", "EC", 65000);
			obj.connection();
			obj.insertStudent();
		//	obj.updateStudent();
			//obj.deleteStudent();
			obj.viewStudentRecord();
			obj.closeConnection();

		}


}
