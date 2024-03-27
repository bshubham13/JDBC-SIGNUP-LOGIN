package jdbc_person;

import java.sql.SQLException;
import java.util.Scanner;

public class PersonMain {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("WELCOME!!! \n1.Sign Up \n2.Login \n3.Exit");
		
		switch (scanner.nextInt()) {
		case 1:{
			System.out.println("Enter id");
			int id = scanner.nextInt();
			
		System.out.println("Enter name ");
		String name= scanner.next(); 
		
		System.out.println("Enter phone"); 
		long phone = scanner.nextLong();
		
		System.out.println("Enter email");
		String email = scanner.next();
		
		System.out.println("Enter password");
		String password = scanner.next();
		
		Person person= new Person();
		person.setId(id);
		person.setName(name);
		person.setPhone(phone);
		person.setEmail(email);
		person.setPassword(password);
		
		personCRUD crud= new personCRUD();
		int result= crud.signUpPerson(person);
		
		if (result!=0) {
			System.out.println("SignUp Success");
		} else {
			System.out.println("SignUp failed1");
		}
		}
		break; 
		 
		case 2:{
			System.out.println("Enter your email");
			String email=scanner.next();
			
			System.out.println("Enter your password");
			String password = scanner.next();
			
			personCRUD crud= new personCRUD();
			crud.loginPerson(email, password);
					
		}
		break;
		
		default: {
			
		} break;
	}

}
}
