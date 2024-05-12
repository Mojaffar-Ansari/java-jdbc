import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDaw;

public class Start {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Student Management App");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("PRESS 1 to ADD student");
			System.out.println("PRESS 2 to Delete student");
			System.out.println("PRESS 3 to display student");
			System.out.println("PRESS 4 to update student");
			System.out.println("PRESS 5 to exit App");
			int c = Integer.parseInt(br.readLine());
			
			if(c==1) {
				//add student
				System.out.println("Enter user name :");
				String name = br.readLine();
				
				System.out.println("Enter user phone :");
				String phone = br.readLine();
				
				System.out.println("Enter user city :");
				String city = br.readLine();
				
				Student st = new Student(name,phone,city);
				boolean insert = StudentDaw.insertStudentToDB(st);
				System.out.println(st);
				
				if(insert) {
					System.out.println("Student is added successfully....");
				}
				else {
					System.out.println("Something went wrong...");
				}
				
			}
			else if(c==2) {
				//delete student
				System.out.println("Please enter the student id to delete :");
				int sid = Integer.parseInt(br.readLine());
				
				boolean delete = StudentDaw.deleteStudentFromDB(sid);
				
				if(delete) {
					System.out.println("Deleted student successfully with id "+ sid);
				}
				else {
					System.out.println("Something went wrong...");
				}
			}
			else if(c==3) {
				//display student
				StudentDaw.displayAllStudentsFromDB();
			}
			else if(c==4) {
				//update student
				System.out.println("Please enter the student id to update :");
				int sid = Integer.parseInt(br.readLine());
				System.out.println("Enter updated name :");
				String name = br.readLine();
				
				System.out.println("Enter updated phone :");
				String phone = br.readLine();
				
				System.out.println("Enter updated city :");
				String city = br.readLine();
				
				boolean  update = StudentDaw.updateStudent(sid, name, phone, city);
				
				if(update) {
					System.out.println("Updated student for id "+sid);
				}
				else {
					System.out.println("Something went wrong...");
				}
			}
			else if(c==5) {
				//exit app
				break;
			}
			else {
				
			}
		}
		System.out.println("Thank you for using my Application...........");
		System.out.println("See you soon");
	}

}
