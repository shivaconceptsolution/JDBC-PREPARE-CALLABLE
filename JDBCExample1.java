package scs;
import java.sql.*;
import java.util.Scanner;
public class JDBCExample1 {
   int rno,fees;
   String sname,branch;
   Connection conn;
   Statement st;
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
      st = conn.createStatement();
      
    }
    
    void insertStudent() throws SQLException
    {
    	int x = st.executeUpdate("insert into student(rno,sname,branch,fees) values('"+rno+"','"+sname+"','"+branch+"','"+fees+"')");
        if(x!=0)
        {
      	  System.out.println("Data Inserted Successfully");
        }
        else
        {
        	 System.out.println("Problem in Data Insertion");
        }
    }
    void updateStudent() throws SQLException
    {
    	System.out.println("Enter rno to update reord");
    	rno=sc.nextInt();
    	int x = st.executeUpdate("update student set sname='"+sname+"',branch='"+branch+"',fees='"+fees+"' where rno='"+rno+"'");
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
    	int x = st.executeUpdate("delete from student  where rno='"+rno+"'");
        if(x!=0)
        {
      	  System.out.println("Data Deleted Successfully");
        }
        else
        {
        	 System.out.println("Problem in Data Deletion");
        }
    }
    void viewStudentRecord() throws SQLException
    {
    	ResultSet res= st.executeQuery("select * from student");
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
		JDBCExample1 obj = new JDBCExample1();
		//obj.accept(1003, "klmn", "IT", 45000);
		obj.connection();
		//obj.insertStudent();
		//obj.updateStudent();
		obj.deleteStudent();
		obj.viewStudentRecord();
		obj.closeConnection();

	}

}
