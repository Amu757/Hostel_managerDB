package addmission;
import java.util.Scanner;
public class Student {
StringBuffer  fname = new StringBuffer();
StringBuffer  lname = new StringBuffer();
StringBuffer  dob= new StringBuffer();
StringBuffer  city= new StringBuffer();
StringBuffer  percent= new StringBuffer();
StringBuffer  college= new StringBuffer();
StringBuffer  cource= new StringBuffer();
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
	
public static void main(String[] args) {
	Student st = new Student();
	st.add_info();
}
	
}//class


