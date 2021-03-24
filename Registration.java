package scs;

import java.sql.*;

public class Registration {

	public static void main(String[] args) throws Exception {
		 Class.forName("com.mysql.jdbc.Driver");
	     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo","root","");
	     CallableStatement st = conn.prepareCall("{call insertreg(?,?,?,?)}");
	     st.setString(1,"mno123");
	     st.setString(2,"12345");
	     st.setString(3,"xyz1@gmail.com");
	     st.setString(4,"7890123456");
	     int x = st.executeUpdate();
	     if(x!=0)
	     {
	    	 System.out.println("Reg successfull");
	     }
	     else
	     {
	    	 System.out.println("Reg not successfull");
	     }
	     
	     conn.close();

	}

}
