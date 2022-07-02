package addmission;
import java.sql.*;
import java.util.Scanner;
public class Student {
StringBuffer  fname = new StringBuffer();
StringBuffer  lname = new StringBuffer();
StringBuffer  dob= new StringBuffer();
StringBuffer  city= new StringBuffer();
StringBuffer  percent= new StringBuffer();
StringBuffer  college= new StringBuffer();
StringBuffer  cource= new StringBuffer();
	// program requires a existing database with name Hostel_management and a existing table name boys_addmission
void options() {
	boolean reapeat=true;
	Scanner sc = new Scanner(System.in);
	while(reapeat) {
	System.out.println("\n_______Enter your choice_______ ");
	System.out.println("1. add new student info to hostel DB");
	System.out.println("2. show students addmisions list");
	System.out.println("0. to Exit program");
	int num=sc.nextInt();
		if(num==1) {
			add_info();			
		}if(num==2) {			
			show_info();
		}if(num==0) {
			sc.close();
			break;
		}
	} //end while	
}//end of options
String makestring() {
	String ans="insert into boys_addmission values(null,'";
	ans +=fname.toString();
	ans +="','";
	ans +=lname.toString();
	ans +="','";
	ans +=dob.toString();
	ans +="','";
	ans +=city.toString();
	ans +="',";
	ans +=percent.toString();
	ans +=",'";
	ans +=college.toString();
	ans +="','";
	ans +=cource.toString();
	ans +="')";
	System.out.println(ans);
	return ans;
}

void add_info(){
Scanner sc = new Scanner(System.in);
System.out.println("Enter your first name");
fname.append(sc.next());
System.out.println("Enter last name");
lname.append(sc.next());
System.out.println("date of birth in  dd/mm/yyyy");
dob.append(sc.next());
System.out.println("city");
city.append(sc.next());
System.out.println("lastyear percentage");
percent.append(sc.nextFloat());
sc.nextLine();
System.out.println("current college name");
college.append(sc.nextLine());
System.out.println("cource name");
cource.append(sc.nextLine());

String query = makestring();  //making string query
System.out.println(query);
submitdata sub = new submitdata();
sub.submit(query);    // call submit data

 sc.close();
 } //add_info
	
void show_info() {
 try {
	 submitdata sub = new submitdata();
	String query="select * from boys_addmission";
	Statement stmt = sub.connect();  //call to connect method
	ResultSet rs = stmt.executeQuery(query);
	System.out.println("ROLLNUM  FIRST_NAME   LAST_NAME    DOB    CITY   LAST_PERCENT  COLLEGE   COURCE");
 while(rs.next()) {
	System.out.println(rs.getInt("rollnum")+"\t"+rs.getString("first_name")+"\t"+rs.getString("last_name")+"\t"+rs.getString("dob")+"\t"+rs.getString("city")+"\t"+rs.getString("last_yr_percent")+"\t"+rs.getString("college")+"\t"+rs.getString("cource"));
	}
 } catch (Exception e) {
	System.out.println("problem inside show info"+e);
	}
}

public static void main(String[] args) {
	Student st = new Student();
	st.options();
   }	
}//class


