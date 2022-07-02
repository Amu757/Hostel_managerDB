package addmission;

import java.sql.*;
public class submitdata {
Statement connect() {
	Statement stm=null;
	String url,user,pass;
	url="jdbc:mysql://localhost:3306/Hostel_management";
	user="root";
	pass="Waghmare@2001";	
	try {
	Connection con = DriverManager.getConnection(url,user,pass);
	Statement stmt = con.createStatement();		
	stm =stmt;  // obj copy
	}catch(Exception e) {
		System.out.println("problem in conect  "+e);
	}
	return stm;
}

void submit(String query) {
	try {
		Statement stmt = connect();  //call to connect method
		int result = stmt.executeUpdate(query);
		if(result==1)
			 System.out.println("1 student added successfuly");
	   } catch (Exception e) {
		System.out.println("problem "+e);
		// TODO: handle exception
	  } 
   }

}
