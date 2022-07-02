package addmission;

import java.sql.*;
public class submitdata {
void submit(String query) {
	String url,user,pass;
	url="jdbc:mysql://localhost:3306/Hostel_management";
	user="root";
	pass="Waghmare@2001";
	
	try {
//		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,pass);
		Statement stmt = con.createStatement();
		int result = stmt.executeUpdate(query);
		if(result==1)
			 System.out.println("done properly");
	} catch (Exception e) {
		System.out.println("problem "+e);
		// TODO: handle exception
	}
	System.out.println("end of submit ");
}
}
