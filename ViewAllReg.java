package scs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ViewAllReg {

	public static void main(String[] args) throws Exception {
		 Class.forName("com.mysql.jdbc.Driver");
	     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo","root","");
	     CallableStatement st = conn.prepareCall("{call getreg()}");
	    
	     ResultSet x = st.executeQuery();
	     while(x.next())
	     {
	    	 System.out.println(x.getString(1) + "," + x.getString(2) + " "+ x.getString(3) + " "+x.getString(4));
	     }
	     
	     
	     conn.close();

	}

}
