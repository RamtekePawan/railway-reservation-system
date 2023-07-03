package org.example.userdomain;
import java.time.LocalDate;
import java.util.Scanner;

public class Login{
	public String id;
	public String pass;
	public String password;
	// Login class User gets id & password from here
	
	public void getid() {
		try (//  For taking input from user
		Scanner sc = new Scanner(System.in)) {
			//  For displaying date 
			LocalDate Date = LocalDate.now();

			System.out.println("\nCreate your id:");
			id = sc.nextLine();

			System.out.println("Create the Password: ");
			password = sc.nextLine();

			System.out.println("\nYou set password on date: " + Date);
		}

		pass = password;
	}
}

